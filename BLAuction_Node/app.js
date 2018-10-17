var http = require('http');
var Web3 = require('web3');
var db = require('./oracleConnection');
var auction = require('./auction');

http.createServer(function (req, res) {
    res.writeHead(200, {'Content-Type': 'text/html'});
    res.end('Hello World!');
}).listen(9000);

console.log("test");

var web3 = new Web3(
    new Web3.providers.WebsocketProvider('wss://kovan.infura.io/ws/1b634aaa684e42fbbba12e68027076ff')
);

//console.log(web3);

var address = "";
var key = '';

//db.auctionConfirm("asdf", 1);
//db.bidConfirm(2, 1, 200000, 15123141);
function makeAuction(address){
    var temp = new web3.eth.Contract(auction.ABI, address);
    return temp;
}

var auction_map = new Map();

var auction_manager_contract = new web3.eth.Contract(auction.manager_ABI,auction.manager_address);

var makeAuctionEvent = auction_manager_contract.events.makeAuctionEvent(
    function(err, res){
        //var auction = new web3.eth.Contract(auction.ABI, res.returnValues.auction_address);
        console.log("auction created");
        console.log(res);
        console.log();
        var tempAuction = makeAuction(res.returnValues.auction_address);
        var biddingEvent = tempAuction.events.biddingEvent(function(err, res){
            console.log('bidding event');
            console.log(res.returnValues);
            console.log();
            db.bidConfirm(res.returnValues.member_id, res.returnValues.auct_id, res.returnValues.price, res.returnValues.time);
        });
        tempAuction.events.ownerWithdrawEvent(function(err, res){
            // auction.biddingEvent().stopWatching();
            // auction.ownerWithdrawEvent().stopWatching();
            console.log("owner withdraw");
            console.log(res.returnValues);
            console.log();
        });

        auction_map.set(res.returnValues.auction_address, auction);
        db.auctionConfirm(res.returnValues.auction_address, res.returnValues.auction_id);
    }
).on('data', event => {
    //console.log('new event:', event)
    //console.log(event.returnValue);
}).on('changed', event => {
    console.log('event removed from blockchain:', event)
}).on('error', error => {
    console.error(error)
});


//http://blog.semo.io/21 geth 설치
