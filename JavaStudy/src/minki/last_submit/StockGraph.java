package minki.last_submit;

import java.util.ArrayList;

public class StockGraph {
	ArrayList<Stock> stockList = new ArrayList<>();

	private StockGraph() {};
		
	private static StockGraph instance = new StockGraph();
	
	
	public static StockGraph getInstance() {
		return instance;
	}


	public static void setInstance(StockGraph instance) {
		StockGraph.instance = instance;
	}
	
	public ArrayList<Stock> getStockList() {
		return stockList;
	}


	public void setStockList(ArrayList<Stock> stockList) {
		this.stockList = stockList;
	}


	public void drawGraph() {
		
	}
}
