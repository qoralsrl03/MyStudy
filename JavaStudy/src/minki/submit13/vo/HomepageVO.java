package minki.submit13.vo;

public class HomepageVO {
	private String custId;
	private String custPw;

	@Override
	public String toString() {
		return custId;
	}

	public HomepageVO() {
	}
	
	public HomepageVO(String custId) {
		this.custId = custId;
	}

	public HomepageVO(String custId, String custPw) {
		this.custId = custId;
		this.custPw = custPw;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustPw() {
		return custPw;
	}

	public void setCustPw(String custPw) {
		this.custPw = custPw;
	}


}
