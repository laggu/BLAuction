package vo;

public class Auction_TypeVO {

	private int auct_type_id;
	private String auct_type_name;
	
	
	public Auction_TypeVO(int auct_type_id, String auct_type_name) {
		super();
		this.auct_type_id = auct_type_id;
		this.auct_type_name = auct_type_name;
	}
	public Auction_TypeVO()
	{
		
	}
	public int getAuct_type_id() {
		return auct_type_id;
	}
	public void setAuct_type_id(int auct_type_id) {
		this.auct_type_id = auct_type_id;
	}
	public String getAuct_type_name() {
		return auct_type_name;
	}
	public void setAuct_type_name(String auct_type_name) {
		this.auct_type_name = auct_type_name;
	}
	@Override
	public String toString() {
		return "Auction_Type [auct_type_id=" + auct_type_id + ", auct_type_name=" + auct_type_name + "]";
	}
	
}
