package minki.submitlast.vo;

public class LoginVO {
	private String custId;
	private String custPw;
	
	@Override
	public String toString() {
		return "StockDBVO [custId=" + custId + ", custPw=" + custPw + "]";
	}

	public LoginVO() {}
	
	public LoginVO(String custId, String custPw) {
		super();
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
