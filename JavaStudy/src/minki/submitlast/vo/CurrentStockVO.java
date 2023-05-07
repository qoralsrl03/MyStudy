package minki.submitlast.vo;

public class CurrentStockVO {
	private String stockname; // 주식이름
	private double clpr; // 현재 주식 가격(2022-11-30)
	private double hipr; // 최고가
	private double lopr; // 최저가

	public CurrentStockVO() {
	}

	public CurrentStockVO(String stockname, double clpr, double hipr, double lopr) {
		this.stockname = stockname;
		this.clpr = clpr;
		this.hipr = hipr;
		this.lopr = lopr;
	}

	@Override
	public String toString() {
		return "CurrentStockVO [clpr=" + clpr + ", hipr=" + hipr + ", lopr=" + lopr + ", stockname=" + stockname + "]";
	}

	public double getClpr() {
		return clpr;
	}

	public void setClpr(double clpr) {
		this.clpr = clpr;
	}

	public double getHipr() {
		return hipr;
	}

	public void setHipr(double hipr) {
		this.hipr = hipr;
	}

	public double getLopr() {
		return lopr;
	}

	public void setLopr(double lopr) {
		this.lopr = lopr;
	}

	public String getStockname() {
		return stockname;
	}

	public void setStockname(String stockname) {
		this.stockname = stockname;
	}

}
