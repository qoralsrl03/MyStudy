package minki.last_submit;

public class Stock {
	private String stockname; 			// 주식이름
	private int nowprice; 				// 주식의 현재 가격
	private int preprice;				// 전날 가격
	private double percent; 			// 전일 대비 오늘의 주식의 퍼센트	
	public Stock() {}
	
	public Stock(String stockname, int nowprice, double percent) {
		super();
		this.stockname = stockname;
		this.nowprice = nowprice;
		setPercent(nowprice/preprice);
	}
		
	@Override
	public String toString() {
		return "Stock [stockname=" + stockname + ", nowprice=" + nowprice + ", percent=" + percent + "]";
	}

	public String getStockname() {
		return stockname;
	}
	public void setStockname(String stockname) {
		this.stockname = stockname;
	}
	public int getNowprice() {
		return nowprice;
	}
	public void setNowprice(int nowprice) {
		this.nowprice = nowprice;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}
	
	
	
}
