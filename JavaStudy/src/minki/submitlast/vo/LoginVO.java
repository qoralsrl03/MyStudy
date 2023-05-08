package minki.submitlast.vo;

public class LoginVO {
	private String custId;
	private String custPw;
	private String custName;
	private double wallet;

	

	@Override
	public String toString() {
		return "LoginVO [custId=" + custId + ", custPw=" + custPw + ", custName=" + custName + ", wallet=" + wallet
				+ "]";
	}

	public LoginVO() {
	}

	public LoginVO(String custId, String custPw) {
		super();
		this.custId = custId;
		this.custPw = custPw;
	}

	public LoginVO(String custId, String custPw, String custName) {
		super();
		this.custId = custId;
		this.custPw = custPw;
		this.custName = custName;
	}

	
	public LoginVO(String custId, String custPw, String custName, double wallet) {
		super();
		this.custId = custId;
		this.custPw = custPw;
		this.custName = custName;
		this.wallet = wallet;
	}

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
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
