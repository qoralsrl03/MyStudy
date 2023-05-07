package minki.submitlast.dao;

import java.util.ArrayList;
import java.util.TimerTask;

import minki.submitlast.service.StockService;
import minki.submitlast.vo.CurrentStockVO;

public class StockBoardTask extends TimerTask {
	private StockService stockService = StockService.getInstance();

	@Override
	public void run() {
		ArrayList<CurrentStockVO> result = stockService.stockBoard();
		System.out.println("===== STOCK BOARD =====");
		for (CurrentStockVO vo : result) {
			System.out.println(vo);
		}
		System.out.println("=======================");
	}
}
