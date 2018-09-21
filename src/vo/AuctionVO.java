package vo;

import java.sql.Date;

public class AuctionVO {

	private int auct_id;
	private int seller_id;
	private Date duedate;
	private int type;
	private String auct_title;
	private int start_price;
	private String seller_account;
	private int category;
	private String description;
	private int down_price;
	private int down_term;
	
	
	public AuctionVO(int auct_id, int seller_id, Date duedate, int type, String auct_title, int start_price,
			String seller_account, int category, String description, int down_price, int down_term) {
		super();
		this.auct_id = auct_id;
		this.seller_id = seller_id;
		this.duedate = duedate;
		this.type = type;
		this.auct_title = auct_title;
		this.start_price = start_price;
		this.seller_account = seller_account;
		this.category = category;
		this.description = description;
		this.down_price = down_price;
		this.down_term = down_term;
	}
	
	public AuctionVO()
	{
		
	}
	public int getAuct_id() {
		return auct_id;
	}
	public void setAuct_id(int auct_id) {
		this.auct_id = auct_id;
	}
	public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	public Date getDuedate() {
		return duedate;
	}
	public void setDuedate(Date duedate) {
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
	public int getStart_price() {
		return start_price;
	}
	public void setStart_price(int start_price) {
		this.start_price = start_price;
	}
	public String getSeller_account() {
		return seller_account;
	}
	public void setSeller_account(String seller_account) {
		this.seller_account = seller_account;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDown_price() {
		return down_price;
	}
	public void setDown_price(int down_price) {
		this.down_price = down_price;
	}
	public int getDown_term() {
		return down_term;
	}
	public void setDown_term(int down_term) {
		this.down_term = down_term;
	}
	@Override
	public String toString() {
		return "AuctionVo [auct_id=" + auct_id + ", seller_id=" + seller_id + ", duedate=" + duedate + ", type=" + type
				+ ", auct_title=" + auct_title + ", start_price=" + start_price + ", seller_account=" + seller_account
				+ ", category=" + category + ", description=" + description + ", down_price=" + down_price
				+ ", down_term=" + down_term + "]";
	}
	
	
}
