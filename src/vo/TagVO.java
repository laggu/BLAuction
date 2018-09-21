package vo;

public class TagVO {

	private int tag_id;
	private String tag_name;
	private int auct_id;
	
	
	public TagVO(int tag_id, String tag_name, int auct_id) {
		super();
		this.tag_id = tag_id;
		this.tag_name = tag_name;
		this.auct_id = auct_id;
	}
	public TagVO()
	{
		
	}
	public int getTag_id() {
		return tag_id;
	}
	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}
	public String getTag_name() {
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	public int getAuct_id() {
		return auct_id;
	}
	public void setAuct_id(int auct_id) {
		this.auct_id = auct_id;
	}
	@Override
	public String toString() {
		return "TagVO [tag_id=" + tag_id + ", tag_name=" + tag_name + ", auct_id=" + auct_id + "]";
	}
	
	
}
