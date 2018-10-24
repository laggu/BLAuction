package com.bla.vo;

public class AdminVO {
	private String admin_code;

	public String getAdmin_code() {
		return admin_code;
	}

	public void setAdmin_code(String admin_code) {
		this.admin_code = admin_code;
	}

	public AdminVO(String admin_code) {
		this.admin_code = admin_code;
	}

	@Override
	public String toString() {
		return "AdminVO [admin_code=" + admin_code + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin_code == null) ? 0 : admin_code.hashCode());
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
		AdminVO other = (AdminVO) obj;
		if (admin_code == null) {
			if (other.admin_code != null)
				return false;
		} else if (!admin_code.equals(other.admin_code))
			return false;
		return true;
	}

}
