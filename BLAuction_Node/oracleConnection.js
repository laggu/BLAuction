var oracledb = require('oracledb');

//http://hellogohn.com/post_one278

function auctionConfirm(auction_address, auction_id) {
    oracledb.getConnection(
        {
            user          : "team20s",
            password      : "blauction",
            connectString : "blauction.czitde7cvox2.ap-northeast-2.rds.amazonaws.com/TEAM20S"
        },
        function(err, connection) {
            if (err) {
                console.error(err.message);
                return;
            }
            connection.execute(
                `UPDATE AUCTION SET auction_address= :auction_address WHERE auct_id = :auction_id`,
                [auction_address, auction_id],  // bind value for :id
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
        {
            user          : "team20s",
            password      : "blauction",
            connectString : "blauction.czitde7cvox2.ap-northeast-2.rds.amazonaws.com/TEAM20S"
        },
        function(err, connection) {
            if (err) {
                console.error(err.message);
                return;
            }
            connection.execute(
                `UPDATE BID SET BID_CONF_STATUS=1 WHERE member_id= :member_id, auct_id = :auct_id, price= :price, time= :time`,
                [member_id, auct_id, price, time],  // bind value for :id
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

