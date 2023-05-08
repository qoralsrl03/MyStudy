package minki.submitlast.service;

import java.util.ArrayList;

import minki.submitlast.vo.CurrentStockVO;

public class RunStock extends Thread {
	private ArrayList<CurrentStockVO> csv = new ArrayList<>();

	@Override
	public void run() {
		while (true) {
			try {
				for (int i = 0; i < csv.size(); i++) {
					int random = (int) (Math.random() * 2) + 0;
					if (random == 1) {
						
						double rand = ((Math.random() * 10) - 5);
						if (rand > 0) {
							csv.get(i).setClpr(csv.get(i).getClpr() + (csv.get(i).getClpr() * (rand / 100)));
						} else {
							csv.get(i).setClpr(csv.get(i).getClpr() + (csv.get(i).getClpr() * (rand / 100)));
						}
						

						double hipr = (csv.get(i).getHipr() > csv.get(i).getClpr()) ? (csv.get(i).getHipr()) : (csv.get(i).getClpr());
						csv.get(i).setHipr(hipr);
						double lopr = (csv.get(i).getLopr() < csv.get(i).getClpr()) ? csv.get(i).getLopr() : csv.get(i).getClpr();
						csv.get(i).setLopr(lopr);						
					}
				}
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<CurrentStockVO> getCsv() {
		return csv;
	}

	public void setCsv(ArrayList<CurrentStockVO> al) {
		this.csv = al;
	}

}
