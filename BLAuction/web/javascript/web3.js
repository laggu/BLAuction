/* 브라우저의 MetaMask 주소 값으로 web3 호출 */

var auction_ABI = [
	{
		"constant": true,
		"inputs": [],
		"name": "getBidCount",
		"outputs": [
			{
				"name": "",
				"type": "uint256"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [],
		"name": "getAllData",
		"outputs": [
			{
				"name": "",
				"type": "uint256"
			},
			{
				"name": "",
				"type": "uint256"
			},
			{
				"name": "",
				"type": "uint8"
			},
			{
				"name": "",
				"type": "uint256"
			},
			{
				"name": "",
				"type": "uint256"
			},
			{
				"name": "",
				"type": "address"
			},
			{
				"name": "",
				"type": "uint256"
			},
			{
				"components": [
					{
						"name": "bid_id",
						"type": "uint256"
					},
					{
						"name": "bidder_id",
						"type": "uint256"
					},
					{
						"name": "bidder_name",
						"type": "string"
					},
					{
						"name": "price",
						"type": "uint256"
					},
					{
						"name": "time",
						"type": "uint256"
					},
					{
						"name": "bidder_address",
						"type": "address"
					}
				],
				"name": "",
				"type": "tuple[]"
			},
			{
				"name": "",
				"type": "address"
			},
			{
				"name": "",
				"type": "bool"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [
			{
				"name": "",
				"type": "address"
			}
		],
		"name": "user_balances",
		"outputs": [
			{
				"name": "",
				"type": "uint256"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [
			{
				"name": "index",
				"type": "uint256"
			}
		],
		"name": "getBid",
		"outputs": [
			{
				"name": "",
				"type": "string"
			},
			{
				"name": "",
				"type": "uint256"
			},
			{
				"name": "",
				"type": "uint256"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": false,
		"inputs": [],
		"name": "withdraw",
		"outputs": [],
		"payable": true,
		"stateMutability": "payable",
		"type": "function"
	},
	{
		"constant": false,
		"inputs": [
			{
				"name": "_bidder_name",
				"type": "string"
			},
			{
				"name": "bidder_id",
				"type": "uint256"
			},
			{
				"name": "time",
				"type": "uint256"
			}
		],
		"name": "bidding",
		"outputs": [],
		"payable": true,
		"stateMutability": "payable",
		"type": "function"
	},
	{
		"constant": false,
		"inputs": [
			{
				"name": "fee",
				"type": "uint256"
			}
		],
		"name": "withdraw_for_owner",
		"outputs": [],
		"payable": true,
		"stateMutability": "payable",
		"type": "function"
	},
	{
		"constant": false,
		"inputs": [
			{
				"name": "status",
				"type": "bool"
			}
		],
		"name": "set_delivery_status",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"inputs": [
			{
				"name": "_auction_id",
				"type": "uint256"
			},
			{
				"name": "_seller_id",
				"type": "uint256"
			},
			{
				"name": "_auction_type",
				"type": "uint8"
			},
			{
				"name": "_due_date",
				"type": "uint256"
			},
			{
				"name": "_start_price",
				"type": "uint256"
			},
			{
				"name": "_owner",
				"type": "address"
			},
			{
				"name": "_manager",
				"type": "address"
			}
		],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "constructor"
	},
	{
		"anonymous": false,
		"inputs": [
			{
				"indexed": false,
				"name": "member_id",
				"type": "uint256"
			},
			{
				"indexed": false,
				"name": "auct_id",
				"type": "uint256"
			},
			{
				"indexed": false,
				"name": "price",
				"type": "uint256"
			},
			{
				"indexed": false,
				"name": "time",
				"type": "uint256"
			},
			{
				"indexed": false,
				"name": "_bidder_name",
				"type": "string"
			}
		],
		"name": "biddingEvent",
		"type": "event"
	},
	{
		"anonymous": false,
		"inputs": [],
		"name": "refundEvent",
		"type": "event"
	},
	{
		"anonymous": false,
		"inputs": [
			{
				"indexed": false,
				"name": "auction_id",
				"type": "uint256"
			}
		],
		"name": "ownerWithdrawEvent",
		"type": "event"
	},
	{
		"anonymous": false,
		"inputs": [],
		"name": "auctionEndEvent",
		"type": "event"
	}
];
var auction_manager_ABI = [
	{
		"constant": false,
		"inputs": [
			{
				"name": "_auction_id",
				"type": "uint256"
			},
			{
				"name": "_seller_id",
				"type": "uint256"
			},
			{
				"name": "_due_date",
				"type": "uint256"
			},
			{
				"name": "_start_price",
				"type": "uint256"
			},
			{
				"name": "_auction_type",
				"type": "uint8"
			},
			{
				"name": "_down_price",
				"type": "uint256"
			},
			{
				"name": "_down_term",
				"type": "uint256"
			}
		],
		"name": "makeAuction",
		"outputs": [
			{
				"name": "",
				"type": "address"
			}
		],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"constant": false,
		"inputs": [
			{
				"name": "newManager",
				"type": "address"
			}
		],
		"name": "setManagerAddress",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"inputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "constructor"
	},
	{
		"anonymous": false,
		"inputs": [
			{
				"indexed": false,
				"name": "auction_address",
				"type": "address"
			},
			{
				"indexed": false,
				"name": "auction_id",
				"type": "uint256"
			}
		],
		"name": "makeAuctionEvent",
		"type": "event"
	},
	{
		"constant": true,
		"inputs": [
			{
				"name": "",
				"type": "uint256"
			}
		],
		"name": "auctions",
		"outputs": [
			{
				"name": "",
				"type": "address"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [
			{
				"name": "_auction_id",
				"type": "uint256"
			}
		],
		"name": "getAuction",
		"outputs": [
			{
				"name": "",
				"type": "address"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	}
];

$(document).ready(function(){
    if( typeof web3 !== 'undefined')
    {
        <!--현재 이더리움 네트워크에 연결된 커넥션 정보-->
        web3 = new Web3(web3.currentProvider)
        client_address = web3.eth.accounts[0];
    }
    else{
        alert('metamask를 준비하세요.')
        alert('없으면 수동으로 이더리움넷에 접속합니다.')
        web3 = new Web3(Web3.providers.HttpProvider('이더리움 넷 주소'))
    }
    
  
})

	<!-- Variables -->
var client_address = ''
var bidder_id = 0

	/* ************************************* */
	/* ********** Auction Manager ********** */
	/* ************************************* */

var auction_manager_address = '0x91e62f2014cf23f6f37bc38a32818d8576e57cc7'
var manager = web3.eth.contract(auction_manager_ABI).at(auction_manager_address)

/**
 * 1. Ajax로 DB에 경매정보를 등록
 * 2. fallback function으로 auction_id를 반환받음
 * 3. 반환받은 auction_id 및 경매정보로 Auction_Manager의 makeAuction을 실행
 * 4. makeAuctionEvent를 통해서 경매등록 시 이벤트 처리
 */
function makeAuction(){
	
	var form = new FormData(document.getElementById('auction_form'));
	
	var register_date = new Date().getTime();
	form.append("register_date", register_date);
	var description = $('#summernote').summernote('code');
	form.append("description", description);
	
	$.ajax({
		type:'POST',
		url:'/BLAuction/createAuctionimpl.bla',
		processData: false,
        contentType: false,
		data:form,
		success:function(data){
			console.log(data);
			console.log(typeof data.auction_id);
			console.log(typeof data.seller_id);
			console.log(typeof data.due_date);
			console.log(typeof data.start_price);
			console.log(typeof data.auction_type);
			console.log(typeof data.down_price);
			console.log(typeof data.down_term);
			
			manager.makeAuction(data.auction_id, data.seller_id, data.due_date, data.start_price, data.auction_type, data.down_price, data.down_term, 
					function(err,res){
				location.href="main.bla";
			});
		},
		error:function(data){
			alert("/BLAuction/createAuctionimpl.bla fail");
		}
	})
}

/**
 * 옥션의 주소값을 반환하는 함수
 * 반환값을 auction_address 변수에 저장
 */
function getAuction(auction_id){
	manager.getAuction(function(err,res){ 
		auction_address = res
	}, auction_id)
}

/**
 * 경매등록 후 발생하는 이벤트
 */
manager.makeAuctionEvent().watch(function(err,res){
	var auction_id = res.args.auction_id
	var auction_address = res.args.auction_address
	
	/* ↓↓ 등록성공 화면처리 ↓↓ */

	
})

	/* ***************************** */
	/* ********** Auction ********** */
	/* ***************************** */	

/** 
 * Auction 컨트랙을 호출
 * 브라우저가 어떤 Auction에 대해 입찰할지 모르기 때문에 입찰 전 세팅 
 */

	
function set_auction(auction_address){
	var auction = web3.eth.contract(auction_ABI).at(auction_address)
	
	auction.makeBidEvent().watch(function(err,res){
	var bid_id = res.args.bid_id
	/* ↓↓ 입찰성공 화면처리 ↓↓ */
	})
	
	auction.ownerWithdrawEvent().watch(function(err,res){
	var money = res.args.money
	var fee = res.args.fee
	/* ↓↓ 출금성공 화면처리 ↓↓ */
	})
	
	auction.withdrawEvent().watch(function(){
	var money = res.args.money
	/* ↓↓ 환불성공 화면처리 ↓↓ */
	})
	
}

/**
 * 입찰 함수
 * 올림경매 : 현재 입찰자일 때 불가능
 * 내림경매 : 최초 1회만 가능
 * 비밀경매 : 최초 1회만 가능
 * 
 * TODO
 * 1. Ajax로 DB에 입찰자 정보를 등록
 * 2. fallback function으로 bid_id를 반환받음
 * 3. 반환받은 bid_id 및 입찰자 정보로 Auction의 bidding을 실행
 * 4. biddingEvent를 통해서 입찰 성공 시 이벤트 처리
 */
function web3_bidding(auction_id, price, time, bidder_name, bidder_id, auctionAddress, callbackFunc){
    var auction = web3.eth.contract(auction_ABI).at(String(auctionAddress));
    
	auction.bidding.sendTransaction(bidder_name, bidder_id, time, {from:web3.eth.accounts[0], value:web3.toWei(price, "finney")},  function(err, res){
        console.log("bidding() : ")
        console.log(res)
        if(!err){
	        var params = {
				"price": price,
				"auction_id": auction_id,
				"time": time,
			}
	        callbackFunc(params);
        }
    });
}



/** 
 * 낙찰 후 판매자 출금 함수 
 */
function web3_withdraw_for_owner(fee, auctionAddress){
	var auction = web3.eth.contract(auction_ABI).at(auctionAddress);
    
	auction.withdraw_for_owner(fee, function(err,res){
	})
}

function setDeliveryStatus(auctionAddress){
	var auction = web3.eth.contract(auction_ABI).at(auctionAddress);
	auction.set_delivery_status(true, function(err,res){
	});
}

/**
 * 유찰자에 대한 환불 함수
 * TODO
 * 올림경매 : 유찰 시 바로 호출 가능
 * 내림경매 : 호출 불가능
 * 비밀경매 : 경매 종료 후 호출 가능
 */

function web3_withdraw(auctionAddress){
	alert(typeof auctionAddress);
	var auction = web3.eth.contract(auction_ABI).at(auctionAddress);
	auction.withdraw(function(err,res){
	})
}



function web3_getBid(auction, index, bidList, printList, count){
	tempList = []
	auction.getBid(index, function(err,res){
		var temp = {name:res[0], price:res[1], time:res[2]};
		bidList.push(temp);
		tempList.push(true);
		if(Number(count) == tempList.length){
			printList();
		}
	})
}

function web3_getBidList(auctionAddress, bidList, printList){
	var auction = web3.eth.contract(auction_ABI).at(auctionAddress);

	auction.getBidCount(function(err,res){
		var count = res;
		for(var i = 0; i < count; ++i){
			web3_getBid(auction, i, bidList, printList, count);
		}
	})
}

	
	