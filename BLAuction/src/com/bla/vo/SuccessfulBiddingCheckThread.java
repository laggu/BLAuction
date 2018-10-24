package com.bla.vo;

import java.util.ArrayList;
import java.util.Iterator;

import javax.annotation.Resource;

import com.bla.biz.AuctionBiz;
import com.bla.biz.BiddingBiz;
import com.bla.biz.SuccessfulBidBiz;

public class SuccessfulBiddingCheckThread extends Thread{
	@Resource(name = "abiz")
	AuctionBiz abiz;
	
	@Resource(name = "bbiz")
	BiddingBiz bbiz;
	
	@Resource(name = "sbiz")
	SuccessfulBidBiz sbiz;
	
	public void init() {
		this.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			Long current_time = System.currentTimeMillis();
			ArrayList<AuctionVO> auctID_list = null;
			try {
				auctID_list = abiz.selectFinishedAuctIDByCurrentTime(current_time);
				
				Iterator it = auctID_list.iterator();
				
				while(it.hasNext()) {
					AuctionVO auction = (AuctionVO)it.next();
					BiddingVO bidding = bbiz.selectBididByAuctId(auction.getAuct_id());
					if(bidding == null) {
						//fail bid
						auction.setAuction_status("failbid");
						System.out.println("=============================");
						System.out.println("failbid");
						System.out.println(auction);
						System.out.println("=============================");
						abiz.updateStatus(auction);
					}else {
						//success bid
						SuccessfulBidVO successfulBid = new SuccessfulBidVO(auction.getAuct_id(), bidding.getBid_id());
						sbiz.register(successfulBid);
						auction.setAuction_status("end");
						System.out.println("=============================");
						System.out.println("successfulBid");
						System.out.println(auction);
						System.out.println("=============================");
						abiz.updateStatus(auction);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
