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
var auction_manager_address = '0x5364cbc6641b84755d8fa5d4665edd6cef72752c'

module.exports.ABI = auction_ABI;
module.exports.manager_ABI = auction_manager_ABI;
module.exports.manager_address = auction_manager_address;