package minki.submitlast.vo;

public class MyStockVO {
	private int myprice; // 나의 주식 구매 가격
	private String stockname; // 주식이름
	private double stockea; // 나의 주식 보유 갯수
	private int averagecost; // 평균단가
	private int totalcost; // 총 구매 금액
	private double benefitpercent; // (나의 주식 보유 갯수 * 현재 주식의 가격)/총 구매 금액

	public MyStockVO() {

	}

	// TODO 필요/불필요한 변수 추가/제거하고 생성자와 toString() 생성
	//>>>

	public int getMyprice() {
		return myprice;
	}

	public void setMyprice(int myprice) {
		this.myprice = myprice;
	}

	public String getStockname() {
		return stockname;
	}

	public void setStockname(String stockname) {
		this.stockname = stockname;
	}

	public double getStockea() {
		return stockea;
	}

	public void setStockea(double stockea) {
		this.stockea = stockea;
	}

	public int getAveragecost() {
		return averagecost;
	}

	public void setAveragecost(int averagecost) {
		this.averagecost = averagecost;
	}

	public int getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(int totalcost) {
		this.totalcost = totalcost;
	}

	public double getBenefitpercent() {
		return benefitpercent;
	}

	public void setBenefitpercent(double benefitpercent) {
		this.benefitpercent = benefitpercent;
	}

}
