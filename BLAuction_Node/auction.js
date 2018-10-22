var auction_ABI = [
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
var auction_manager_address = '0x8dcd68955cbfd419668c5e0cc419c1e41c5b4252'

module.exports.ABI = auction_ABI;
module.exports.manager_ABI = auction_manager_ABI;
module.exports.manager_address = auction_manager_address;
