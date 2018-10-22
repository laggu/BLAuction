var oracledb = require('oracledb');

//http://hellogohn.com/post_one278
var dbConnection_local =  {
            user          : "BLAuction",//"team20s",
            password      : "1234",//"blauction",
            connectString : "70.12.110.164:1521/xe",//"blauction.czitde7cvox2.ap-northeast-2.rds.amazonaws.com:1521/TEAM20S"
}
var dbConnection =  {
            user          : "team20s",
            password      : "blauction",
            connectString : "blauction.czitde7cvox2.ap-northeast-2.rds.amazonaws.com:1521/TEAM20S"
}
function auctionConfirm(auction_address, auction_id) {
    oracledb.getConnection(
	dbConnection,
        function(err, connection) {
            if (err) {
                console.error(err.message);
                return;
            }
            connection.execute(
                `UPDATE AUCTION SET auction_address= :auction_address WHERE auct_id = :auction_id`,
                [auction_address, auction_id],  // bind value for :id
{autoCommit:true},
                function(err, result) {
                    if (err) {
                        console.error(err.message);
                        doRelease(connection);
                        return;
                    }
                    console.log(result.rows);
                    doRelease(connection);
                });
        });
}

function bidConfirm(member_id, auct_id, price, time) {
    oracledb.getConnection(
dbConnection,
        function(err, connection) {
            if (err) {
                console.error(err.message);
                return;
            }
            connection.execute(
                `UPDATE BIDDING SET BID_CONF_STATUS=1 WHERE member_id= :member_id and auct_id = :auct_id and price= :price and time= :time`,
                [member_id, auct_id, price, time],  // bind value for :id
{autoCommit:true},
                function(err, result) {
                    if (err) {
                        console.error(err.message);
                        doRelease(connection);
                        return;
                    }
                    console.log(result.rows);
                    doRelease(connection);
                });
        });
}

function doRelease(connection) {
    connection.close(
        function(err) {
            if (err)
                console.error(err.message);
        });
}

module.exports.auctionConfirm = auctionConfirm;
module.exports.bidConfirm = bidConfirm;
