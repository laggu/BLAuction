package vo;

import java.util.Date;

public class UserVO {
	private int member_id;
	private String email;
	private String name;
	private String address;
	private String phone;
	private Date birth;
	private int score;
	private int like;
	
	
	public UserVO(int member_id, String email, String name, String address, String phone, Date birth, int score,
			int like) {
		super();
		this.member_id = member_id;
		this.email = email;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.birth = birth;
		this.score = score;
		this.like = like;
	}
	public UserVO()
	{
		
	}
			
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	@Override
	public String toString() {
		return "UserVO [member_id=" + member_id + ", email=" + email + ", name=" + name + ", address=" + address
				+ ", phone=" + phone + ", birth=" + birth + ", score=" + score + ", like=" + like + "]";
	}
	
	

}
