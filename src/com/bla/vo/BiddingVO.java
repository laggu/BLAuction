package com.bla.vo;

import java.util.Date;

public class BiddingVO {

	private int bid_id;
	private int member_id;
	private int auct_id;
	private long price;
	private Date time;
	private String bidder_account;
	private int bid_conf_status;//0 is false, 1 is true;
	
	public BiddingVO() {
		super();
	}

	public BiddingVO(int member_id, int auct_id, long price, Date time, String bidder_account, int bid_conf_status) {
		super();
		this.member_id = member_id;
		this.auct_id = auct_id;
		this.price = price;
		this.time = time;
		this.bidder_account = bidder_account;
		this.bid_conf_status = bid_conf_status;
	}

	public int getBid_id() {
		return bid_id;
	}

	public void setBid_id(int bid_id) {
		this.bid_id = bid_id;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public int getAuct_id() {
		return auct_id;
	}

	public void setAuct_id(int auct_id) {
		this.auct_id = auct_id;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getBidder_account() {
		return bidder_account;
	}

	public void setBidder_account(String bidder_account) {
		this.bidder_account = bidder_account;
	}

	public int getBid_conf_status() {
		return bid_conf_status;
	}

	public void setBid_conf_status(int bid_conf_status) {
		this.bid_conf_status = bid_conf_status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + auct_id;
		result = prime * result + bid_conf_status;
		result = prime * result + bid_id;
		result = prime * result + ((bidder_account == null) ? 0 : bidder_account.hashCode());
		result = prime * result + member_id;
		result = prime * result + (int) (price ^ (price >>> 32));
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BiddingVO other = (BiddingVO) obj;
		if (auct_id != other.auct_id)
			return false;
		if (bid_conf_status != other.bid_conf_status)
			return false;
		if (bid_id != other.bid_id)
			return false;
		if (bidder_account == null) {
			if (other.bidder_account != null)
				return false;
		} else if (!bidder_account.equals(other.bidder_account))
			return false;
		if (member_id != other.member_id)
			return false;
		if (price != other.price)
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BiddingVO [bid_id=" + bid_id + ", member_id=" + member_id + ", auct_id=" + auct_id + ", price=" + price
				+ ", time=" + time + ", bidder_account=" + bidder_account + ", bid_conf_status=" + bid_conf_status
				+ "]";
	}
	
}
