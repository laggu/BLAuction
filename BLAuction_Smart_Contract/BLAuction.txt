pragma solidity ^0.4.24;
pragma experimental ABIEncoderV2;

contract Auction{
    uint auction_id;
    uint seller_id;
    uint8 auction_type;            /// 0 : Up_Auction,     1 : Down_Auction,    2 : Secret_Auction
    uint due_date;
    uint start_price;
    address current_winner;
    uint current_price;
    Bid[] bid_list;
    mapping(address => uint) public user_balances;
    address owner;
    bool delivery_completed;
    
    function getAllData() view public returns (uint, uint, uint8, uint, uint, address, uint, Bid[], address, bool){
        return (auction_id, seller_id, auction_type, due_date, start_price, current_winner, current_price, bid_list, owner, delivery_completed);
    }
    
    event biddingEvent(uint member_id, uint auct_id, uint price, uint time);
    event refundEvent();
    event ownerWithdrawEvent();
    event auctionEndEvent();
    
    modifier auction_progress(uint _time){
        require(due_date > _time);
        _;
    }
    
    modifier auction_end(uint _time){
        require(due_date < _time);
        _;
    }
    
    modifier notOwner(){
        require(owner != msg.sender);
        _;
    }
    
    modifier minimum_measure(){
        require(current_price + 1 finney < msg.value);
        _;
    }
    
    struct Bid{
        uint bid_id;
        uint bidder_id;
        uint price;
        uint time;
        address bidder_address;
    }
    
    constructor(uint _auction_id, uint _seller_id, uint8 _auction_type, uint _due_date, uint _start_price, address _owner) public{
        owner = _owner;
        auction_id = _auction_id;
        seller_id = _seller_id;
        auction_type = _auction_type;
        due_date = _due_date;
        start_price = _start_price;
        delivery_completed = false;
    }
    
    function bidding(uint bid_id, uint bidder_id, uint time) public payable;
    function withdraw() public payable;
    function set_delivery_status(bool status) auction_end(now) public{
        delivery_completed = status;
    }
    function withdraw_for_owner() auction_end(now) public payable{
        require(delivery_completed);
        require(owner == msg.sender);
        require(user_balances[owner] > 0);
        uint money = user_balances[owner];
        user_balances[owner] = 0;
        owner.transfer(money);
        emit ownerWithdrawEvent();
    }
    function get_bid_list() view public returns (Bid[]){
        return bid_list;
    }
}

contract Up_Auction is Auction{
    constructor(uint _auction_id, uint _seller_id, uint8 _auction_type, uint _due_date, uint _start_price, address _owner) Auction(_auction_id, _seller_id, _auction_type, _due_date, _start_price, _owner) public {
        
    }
    
    function bidding(uint _bid_id, uint bidder_id, uint _time) auction_progress(_time) notOwner minimum_measure public payable {
        emit startbidding();
        require(current_price < msg.value);
        bid_list.push(Bid({
            bid_id: _bid_id,
            bidder_id: bidder_id,
            price: msg.value,
            time: _time,
            bidder_address: msg.sender
        }));
        user_balances[current_winner] += current_price;
        current_price = msg.value;
        current_winner = msg.sender;
        user_balances[owner] = current_price;
    }
    
    function withdraw() notOwner public payable{
        if(user_balances[msg.sender] != 0){
            uint money = user_balances[msg.sender];
            user_balances[msg.sender] = 0;
            msg.sender.transfer(money);
        }
    }
}

contract Down_Auction is Auction{
    uint down_price;
    uint down_term;
    
    constructor(uint _auction_id, uint _seller_id, uint8 _auction_type, uint _due_date, uint _start_price, uint _down_price, uint _down_term, address _owner) Auction(_auction_id, _seller_id, _auction_type, _due_date, _start_price, _owner) public {
        down_price = _down_price;
        down_term = _down_term;
    }
    
    function bidding(uint _bid_id, uint bidder_id, uint _time) auction_progress(_time) notOwner public payable {
        bid_list.push(Bid({
            bid_id: _bid_id,
            bidder_id: bidder_id,
            price: msg.value,
            time: _time,
            bidder_address: msg.sender
        }));
        current_price = msg.value;
        current_winner = msg.sender;
        due_date = _time;
        user_balances[owner] = current_price;
    }
    
    function withdraw() public payable{
        
    }
}

contract Secret_Auction is Auction{
    constructor(uint _auction_id, uint _seller_id, uint8 _auction_type, uint _due_date, uint _start_price, address _owner) Auction(_auction_id, _seller_id, _auction_type, _due_date, _start_price, _owner) public {
        
    }
    
    function bidding(uint _bid_id, uint bidder_id, uint _time) auction_progress(_time) notOwner minimum_measure public payable {
        bid_list.push(Bid({
            bid_id: _bid_id,
            bidder_id: bidder_id,
            price: msg.value,
            time: _time,
            bidder_address: msg.sender
        }));
        if(current_price < msg.value){
            user_balances[current_winner] += current_price;
            current_price = msg.value;
            current_winner = msg.sender;
            user_balances[owner] = current_price;
        } else {
            user_balances[msg.sender] += msg.value;
        }
    }
    
    function withdraw() auction_end(now) notOwner public payable{
        if(user_balances[msg.sender] != 0){
            uint money = user_balances[msg.sender];
            user_balances[msg.sender] = 0;
            msg.sender.transfer(money);
        }
    }
}

contract Auction_Manager {
    address private manager;
    mapping (uint => Auction) public auctions;
    
    event makeBidEvent();
    event endAuctionEvent();
    event makeAuctionEvent(address auction_address, uint auction_id);
    event refundEvent();
    event ownerWithdrawEvent();
    event withdrawEvent();

    constructor() public{
        manager = msg.sender;
    }
    
    function makeAuction(uint _auction_id, uint _seller_id, uint _due_date, uint _start_price, uint8 _auction_type, uint _down_price, uint _down_term) public returns (address){
        if(_auction_type == 0){
            auctions[_auction_id] = new Up_Auction(_auction_id, _seller_id, _auction_type, _due_date, _start_price, msg.sender);
        }
        if(_auction_type == 1){
            auctions[_auction_id] = new Down_Auction(_auction_id, _seller_id, _auction_type, _due_date, _start_price, _down_price, _down_term, msg.sender);
        }
        if(_auction_type == 2){
            auctions[_auction_id] = new Secret_Auction(_auction_id, _seller_id, _auction_type, _due_date, _start_price, msg.sender);
        }
        emit makeAuctionEvent(auctions[_auction_id]);
        return auctions[_auction_id];
    }
    
    function getAuction(uint _auction_id) view public returns (address){
        return auctions[_auction_id];
    }
    
    function makeBid(uint _auction_id, uint _bid_id, uint _bidder_id, uint _time) public payable{
        emit makeBidEvent();
        auctions[_auction_id].bidding(_bid_id, _bidder_id, _time);
        emit makeBidEvent();
    }

    function withdraw(uint _auction_id) public{
        auctions[_auction_id].withdraw();
        emit withdrawEvent();
    }
    
    function withdraw_for_owner(uint _auction_id) public {
        auctions[_auction_id].withdraw_for_owner();
        emit withdrawEvent();
    }
}
