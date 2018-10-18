package com.bla.vo;

public class ListVO {
	private AuctionVO auction;
	private String photo_path_1;
	private String photo_path_2;
	private Long max_price;
	private String duedate;
	
	public ListVO() {
	}
	
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	public AuctionVO getAuction() {
		return auction;
	}
	public void setAuction(AuctionVO auction) {
		this.auction = auction;
	}
	public String getPhoto_path_1() {
		return photo_path_1;
	}
	public void setPhoto_path_1(String photo_path_1) {
		this.photo_path_1 = photo_path_1;
	}
	public String getPhoto_path_2() {
		return photo_path_2;
	}
	public void setPhoto_path_2(String photo_path_2) {
		this.photo_path_2 = photo_path_2;
	}
	public Long getMax_price() {
		return max_price;
	}
	public void setMax_price(Long max_price) {
		this.max_price = max_price;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auction == null) ? 0 : auction.hashCode());
		result = prime * result + ((duedate == null) ? 0 : duedate.hashCode());
		result = prime * result + ((max_price == null) ? 0 : max_price.hashCode());
		result = prime * result + ((photo_path_1 == null) ? 0 : photo_path_1.hashCode());
		result = prime * result + ((photo_path_2 == null) ? 0 : photo_path_2.hashCode());
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
		ListVO other = (ListVO) obj;
		if (auction == null) {
			if (other.auction != null)
				return false;
		} else if (!auction.equals(other.auction))
			return false;
		if (duedate == null) {
			if (other.duedate != null)
				return false;
		} else if (!duedate.equals(other.duedate))
			return false;
		if (max_price == null) {
			if (other.max_price != null)
				return false;
		} else if (!max_price.equals(other.max_price))
			return false;
		if (photo_path_1 == null) {
			if (other.photo_path_1 != null)
				return false;
		} else if (!photo_path_1.equals(other.photo_path_1))
			return false;
		if (photo_path_2 == null) {
			if (other.photo_path_2 != null)
				return false;
		} else if (!photo_path_2.equals(other.photo_path_2))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ListVO [auction=" + auction + ", photo_path_1=" + photo_path_1 + ", photo_path_2=" + photo_path_2
				+ ", max_price=" + max_price + ", duedate=" + duedate + "]";
	}

	
	
}
