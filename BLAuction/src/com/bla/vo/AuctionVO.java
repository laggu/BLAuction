package com.bla.vo;

public class AuctionVO {
	private int auct_id;
	private int member_id;
	private long duedate;
	private int type;
	private String auct_title;
	private long start_price;
	private String seller_account;
	private int category_id;
	private String description;
	private long down_price;
	private int down_term;
	private String auction_status;//auction의 상태는 before, proceeding, end, cancel
	private String auction_address;
	private String tag;
	
	public AuctionVO() {
		super();
	}

	public AuctionVO(int member_id, long duedate, int type, String auct_title, long start_price, String seller_account,
			int category_id, String description, long down_price, int down_term, String auction_status,
			String auction_address, String tag) {
		super();
		this.member_id = member_id;
		this.duedate = duedate;
		this.type = type;
		this.auct_title = auct_title;
		this.start_price = start_price;
		this.seller_account = seller_account;
		this.category_id = category_id;
		this.description = description;
		this.down_price = down_price;
		this.down_term = down_term;
		this.auction_status = auction_status;
		this.auction_address = auction_address;
		this.tag = tag;
	}

	public AuctionVO(int member_id, long duedate, int type, String auct_title, long start_price, String seller_account,
			int category_id, String description, String auction_status, String auction_address, String tag) {
		super();
		this.member_id = member_id;
		this.duedate = duedate;
		this.type = type;
		this.auct_title = auct_title;
		this.start_price = start_price;
		this.seller_account = seller_account;
		this.category_id = category_id;
		this.description = description;
		this.auction_status = auction_status;
		this.auction_address = auction_address;
		this.tag = tag;
	}

	public int getAuct_id() {
		return auct_id;
	}

	public void setAuct_id(int auct_id) {
		this.auct_id = auct_id;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public long getDuedate() {
		return duedate;
	}

	public void setDuedate(long duedate) {
		this.duedate = duedate;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getAuct_title() {
		return auct_title;
	}

	public void setAuct_title(String auct_title) {
		this.auct_title = auct_title;
	}

	public long getStart_price() {
		return start_price;
	}

	public void setStart_price(long start_price) {
		this.start_price = start_price;
	}

	public String getSeller_account() {
		return seller_account;
	}

	public void setSeller_account(String seller_account) {
		this.seller_account = seller_account;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getDown_price() {
		return down_price;
	}

	public void setDown_price(long down_price) {
		this.down_price = down_price;
	}

	public int getDown_term() {
		return down_term;
	}

	public void setDown_term(int down_term) {
		this.down_term = down_term;
	}

	public String getAuction_status() {
		return auction_status;
	}

	public void setAuction_status(String auction_status) {
		this.auction_status = auction_status;
	}

	public String getAuction_address() {
		return auction_address;
	}

	public void setAuction_address(String auction_address) {
		this.auction_address = auction_address;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + auct_id;
		result = prime * result + ((auct_title == null) ? 0 : auct_title.hashCode());
		result = prime * result + ((auction_address == null) ? 0 : auction_address.hashCode());
		result = prime * result + ((auction_status == null) ? 0 : auction_status.hashCode());
		result = prime * result + category_id;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (down_price ^ (down_price >>> 32));
		result = prime * result + down_term;
		result = prime * result + (int) (duedate ^ (duedate >>> 32));
		result = prime * result + member_id;
		result = prime * result + ((seller_account == null) ? 0 : seller_account.hashCode());
		result = prime * result + (int) (start_price ^ (start_price >>> 32));
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
		result = prime * result + type;
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
		AuctionVO other = (AuctionVO) obj;
		if (auct_id != other.auct_id)
			return false;
		if (auct_title == null) {
			if (other.auct_title != null)
				return false;
		} else if (!auct_title.equals(other.auct_title))
			return false;
		if (auction_address == null) {
			if (other.auction_address != null)
				return false;
		} else if (!auction_address.equals(other.auction_address))
			return false;
		if (auction_status == null) {
			if (other.auction_status != null)
				return false;
		} else if (!auction_status.equals(other.auction_status))
			return false;
		if (category_id != other.category_id)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (down_price != other.down_price)
			return false;
		if (down_term != other.down_term)
			return false;
		if (duedate != other.duedate)
			return false;
		if (member_id != other.member_id)
			return false;
		if (seller_account == null) {
			if (other.seller_account != null)
				return false;
		} else if (!seller_account.equals(other.seller_account))
			return false;
		if (start_price != other.start_price)
			return false;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AuctionVO [auct_id=" + auct_id + ", member_id=" + member_id + ", duedate=" + duedate + ", type=" + type
				+ ", auct_title=" + auct_title + ", start_price=" + start_price + ", seller_account=" + seller_account
				+ ", category_id=" + category_id + ", description=" + description + ", down_price=" + down_price
				+ ", down_term=" + down_term + ", auction_status=" + auction_status + ", auction_address="
				+ auction_address + ", tag=" + tag + "]";
	}
	
}
