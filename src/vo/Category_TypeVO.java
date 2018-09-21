package vo;


public class Category_TypeVO {
	private int cate_type_id;
	private String cate_type_name;
	
	
	public Category_TypeVO(int cate_type_id, String cate_type_name) {
		super();
		this.cate_type_id = cate_type_id;
		this.cate_type_name = cate_type_name;
	}
	public Category_TypeVO()
	{
		
	}
	public int getCate_type_id() {
		return cate_type_id;
	}
	public void setCate_type_id(int cate_type_id) {
		this.cate_type_id = cate_type_id;
	}
	public String getCate_type_name() {
		return cate_type_name;
	}
	public void setCate_type_name(String cate_type_name) {
		this.cate_type_name = cate_type_name;
	}
	@Override
	public String toString() {
		return "Category_Type [cate_type_id=" + cate_type_id + ", cate_type_name=" + cate_type_name + "]";
	}

	
}
