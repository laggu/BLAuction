var http = require('http');
var Web3 = require('web3');
var db = require('./oracleConnection');
var auction = require('./auction');

http.createServer(function (req, res) {
    res.writeHead(200, {'Content-Type': 'text/html'});
    res.end('Hello World!');
}).listen(9000);
console.log('server created');

var web3 = new Web3(
    new Web3.providers.WebsocketProvider('wss://kovan.infura.io/ws/1b634aaa684e42fbbba12e68027076ff')
);


var address = "";
var key = '';

function makeAuction(address){
    var temp = new web3.eth.Contract(auction.ABI, address);
    return temp;
}

var auction_map = new Map();

var auction_manager_contract = new web3.eth.Contract(auction.manager_ABI,auction.manager_address);

var makeAuctionEvent = auction_manager_contract.events.makeAuctionEvent(
    function(err, res){
	if(res==null){
		console.log("response null");
		return;
	}
        console.log("auction created");
        console.log(res.returnValues);
        console.log();
        var tempAuction = makeAuction(res.returnValues.auction_address);
        var biddingEvent = tempAuction.events.biddingEvent(function(err, res){
            console.log('bidding event');
            console.log(res.returnValues);
            console.log();
            db.bidConfirm(res.returnValues.member_id, res.returnValues.auct_id, res.returnValues.price * 0.000000000000000001, res.returnValues.time);
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

console.log('start watching event from auction_manager');
