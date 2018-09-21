package vo;

public class PhotoVO {

	private int photo_id;
	private String photo_name;
	private String photo_path;
	private int auct_id;
	
	public PhotoVO(int photo_id, String photo_name, String photo_path, int auct_id) {
		super();
		this.photo_id = photo_id;
		this.photo_name = photo_name;
		this.photo_path = photo_path;
		this.auct_id = auct_id;
	}
	public PhotoVO()
	{
		
	}
	public int getPhoto_id() {
		return photo_id;
	}
	public void setPhoto_id(int photo_id) {
		this.photo_id = photo_id;
	}
	public String getPhoto_name() {
		return photo_name;
	}
	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}
	public String getPhoto_path() {
		return photo_path;
	}
	public void setPhoto_path(String photo_path) {
		this.photo_path = photo_path;
	}
	public int getAuct_id() {
		return auct_id;
	}
	public void setAuct_id(int auct_id) {
		this.auct_id = auct_id;
	}
	@Override
	public String toString() {
		return "PhotoVO [photo_id=" + photo_id + ", photo_name=" + photo_name + ", photo_path=" + photo_path
				+ ", auct_id=" + auct_id + "]";
	}
	
}
