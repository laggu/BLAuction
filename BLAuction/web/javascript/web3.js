/* 브라우저의 MetaMask 주소 값으로 web3 호출 */
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
    
    $("#register_btn").click(function(){
    	makeAuction();
    })
})

	<!-- Variables -->
var client_address = ''
var bidder_id = 0

	/* ************************************* */
	/* ********** Auction Manager ********** */
	/* ************************************* */

var auction_manager_address = '0xc8dee07c79758414a3fb1a59dc1aadb5b3d789f3'
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
		url:'/BLAuction/createAuctionimpl2.bla',
		processData: false,
        contentType: false,
		data:form,
		success:function(data){
			alert(data)
			auction_id = data.auct_id;
			location.href="/BLAuction/createAuction_success.bla"
			alert("1")
			manager.makeAuction(function(err,res){
			}, auction_id, seller_id, due_date, start_price, auction_type, down_price, down_term)
		},
		error:function(data){
			alert("fail")
			alert(data)
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
var auction_address = ''
var auction = ''
	
function set_auction(){
	auction = web3.eth.contract(auction_ABI).at(auction_address)
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
function bidding(price){
	var auction_id /* 쿠키에서 정보를 받아옴*/
	var price = $("#price").val()
	var time = new Date().getTime()
	
	var params = {
		"bidder_id":bidder_id,
		"auction_id":auction_id,
		"price":price,
		"time":time,
		"client_address":client_address
	}
	
	$.ajax({
		type:'POST',
		url:'bidding.bla', /* DB로 접근 */
		data:params,
		datatype:'json',
		success:function(data){
			alert(data)
		},
		error:function(data){
			alert(data)
		}
	})
	
	auction.bidding.sendTransaction(bidder_id, time, {from:client_address, value:web3.toWei(price, "finney")},  function(err, res){
        console.log("bidding() : ")
        console.log(res)
    });
}

auction.makeBidEvent().watch(function(){
	var bid_id = res.args.bid_id
	/* ↓↓ 입찰성공 화면처리 ↓↓ */
})

/** 
 * 낙찰 후 판매자 출금 함수 
 */
function withdraw_for_owner(fee){
	auction.withdraw_for_owner(function(err,res){
	}, fee)
}

auction.ownerWithdrawEvent().watch(function(err,res){
	var money = res.args.money
	var fee = res.args.fee
	/* ↓↓ 출금성공 화면처리 ↓↓ */
	
})

/**
 * 유찰자에 대한 환불 함수
 * TODO
 * 올림경매 : 유찰 시 바로 호출 가능
 * 내림경매 : 호출 불가능
 * 비밀경매 : 경매 종료 후 호출 가능
 */

function withdraw(){
	auction.withdraw(function(err,res){
	})
}

auction.withdrawEvent().watch(function(){
	var money = res.args.money
	/* ↓↓ 환불성공 화면처리 ↓↓ */
})

	/* ************************** */
	/* ********** ABIs ********** */
	/* ************************** */

var auction_ABI = [
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
        "constant": false,
        "inputs": [],
        "name": "withdraw",
        "outputs": [],
        "payable": true,
        "stateMutability": "payable",
        "type": "function"
    },
    {
        "constant": true,
        "inputs": [],
        "name": "get_bid_list",
        "outputs": [
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
            }
        ],
        "payable": false,
        "stateMutability": "view",
        "type": "function"
    },
    {
        "constant": false,
        "inputs": [],
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
                "name": "bid_id",
                "type": "uint256"
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
            }
        ],
        "name": "withdraw",
        "outputs": [],
        "payable": false,
        "stateMutability": "nonpayable",
        "type": "function"
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
    },
    {
        "constant": false,
        "inputs": [
            {
                "name": "_auction_id",
                "type": "uint256"
            }
        ],
        "name": "withdraw_for_owner",
        "outputs": [],
        "payable": false,
        "stateMutability": "nonpayable",
        "type": "function"
    },
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
                "name": "_auction_id",
                "type": "uint256"
            },
            {
                "name": "_bid_id",
                "type": "uint256"
            },
            {
                "name": "_bidder_id",
                "type": "uint256"
            },
            {
                "name": "_time",
                "type": "uint256"
            }
        ],
        "name": "makeBid",
        "outputs": [],
        "payable": true,
        "stateMutability": "payable",
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
        "inputs": [],
        "name": "makeBidEvent",
        "type": "event"
    },
    {
        "anonymous": false,
        "inputs": [],
        "name": "endAuctionEvent",
        "type": "event"
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
        "anonymous": false,
        "inputs": [],
        "name": "refundEvent",
        "type": "event"
    },
    {
        "anonymous": false,
        "inputs": [],
        "name": "ownerWithdrawEvent",
        "type": "event"
    },
    {
        "anonymous": false,
        "inputs": [],
        "name": "withdrawEvent",
        "type": "event"
    }
];

	
	