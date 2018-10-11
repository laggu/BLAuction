var http = require('http');
var Web3 = require('web3');
var db = require('oracleConnection');

http.createServer(function (req, res) {
    res.writeHead(200, {'Content-Type': 'text/html'});
    res.end('Hello World!');
}).listen(9000);

console.log("test");

var web3 = new Web3(
    new Web3.providers.HttpProvider('https://rinkeby.infura.io/')
);

var address = "";
var key = '';

var auction_ABI;
var auction_manager_ABI;
var auction_manager_address;
var auction_map = new Map();

var auction_manager_contract = web3.eth.contract(auction_manager_ABI).at(auction_manager_address);

auction_manager_contract.makeAuctionEvent().watch(function(err, res){
    var auction = web3.eth.contract(auction_ABI).at(res.args.auction_address);
    auction.biddingEvent().watch(function(err, res){
        db.bidConfirm(res.args.member_id, res.args.auct_id, res.args.price, res.args.time);
    });
    auction.ownerWithdrawEvent().watch(function(err, res){
        auction.biddingEvent().stopWatching();
        auction.ownerWithdrawEvent().stopWatching();
        console.log("owner withdraw");
    });

    auction_map.set(res.args.auction_address, auction);
    db.auctionConfirm(res.args.auction_address, res.args.auction_id);
});

//auction_manager_contract.makeAuctionEvent().watc