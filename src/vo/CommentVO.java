package vo;

public class CommentVO {
	
	private int comment_id;
	private String detail;
	
	public CommentVO(int comment_id, String detail) {
		super();
		this.comment_id = comment_id;
		this.detail = detail;
	}
	public CommentVO()
	{
		
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "CommentVO [comment_id=" + comment_id + ", detail=" + detail + "]";
	}
	
	
}
