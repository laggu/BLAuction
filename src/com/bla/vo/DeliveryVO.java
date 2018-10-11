package com.bla.vo;

public class DeliveryVO {
	private String delivery_code;
	private String delivery_status;
	private String payment_status;
	private int company_code;//국내 택배사 코드
	
	public DeliveryVO() {
		super();
	}

	public DeliveryVO(String delivery_code, String delivery_status, String payment_status, int company_code) {
		super();
		this.delivery_code = delivery_code;
		this.delivery_status = delivery_status;
		this.payment_status = payment_status;
		this.company_code = company_code;
	}

	public String getDelivery_code() {
		return delivery_code;
	}

	public void setDelivery_code(String delivery_code) {
		this.delivery_code = delivery_code;
	}

	public String getDelivery_status() {
		return delivery_status;
	}

	public void setDelivery_status(String delivery_status) {
		this.delivery_status = delivery_status;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public int getCompany_code() {
		return company_code;
	}

	public void setCompany_code(int company_code) {
		this.company_code = company_code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + company_code;
		result = prime * result + ((delivery_code == null) ? 0 : delivery_code.hashCode());
		result = prime * result + ((delivery_status == null) ? 0 : delivery_status.hashCode());
		result = prime * result + ((payment_status == null) ? 0 : payment_status.hashCode());
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
		DeliveryVO other = (DeliveryVO) obj;
		if (company_code != other.company_code)
			return false;
		if (delivery_code == null) {
			if (other.delivery_code != null)
				return false;
		} else if (!delivery_code.equals(other.delivery_code))
			return false;
		if (delivery_status == null) {
			if (other.delivery_status != null)
				return false;
		} else if (!delivery_status.equals(other.delivery_status))
			return false;
		if (payment_status == null) {
			if (other.payment_status != null)
				return false;
		} else if (!payment_status.equals(other.payment_status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DeliveryVO [delivery_code=" + delivery_code + ", delivery_status=" + delivery_status
				+ ", payment_status=" + payment_status + ", company_code=" + company_code + "]";
	}
	
}