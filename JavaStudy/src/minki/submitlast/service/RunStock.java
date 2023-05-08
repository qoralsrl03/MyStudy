package minki.submitlast.service;

import java.util.ArrayList;

import minki.submitlast.vo.CurrentStockVO;

public class RunStock extends Thread {
	private String itmsNm;
	private double clpr;
	private double hipr;
	private double lopr;
	private ArrayList<CurrentStockVO> csv = new ArrayList<>();

	@Override
	public void run() {
		while (true) {
			for (int i = 0; i < csv.size(); i++) {
				int random = (int) (Math.random() * 2) + 0;
				if (random == 1) {
					this.itmsNm = csv.get(i).getStockname();
					this.clpr = csv.get(i).getClpr();
					this.hipr = csv.get(i).getHipr();
					this.lopr = csv.get(i).getLopr();

					double rand = (Math.random() * 10) - 5;
					if (rand > 0) {
						this.clpr += clpr * rand;
					} else {
						this.clpr -= clpr * rand;
					}

					this.hipr = (hipr > clpr) ? hipr : clpr;
					this.lopr = (lopr < clpr) ? lopr : clpr;
				}
				csv.add(new CurrentStockVO(itmsNm, clpr, hipr, lopr));
			}

			try {
				Thread.sleep(10000);
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

	@Override
	public String toString() {
		return "RunStock [itmsNm=" + itmsNm + ", clpr=" + clpr + ", hipr=" + hipr + ", lopr=" + lopr + "]";
	}

	public RunStock() {
	}

	public RunStock(String itmsNm, double clpr, double hipr, double lopr) {
		this.itmsNm = itmsNm;
		this.clpr = clpr;
		this.hipr = hipr;
		this.lopr = lopr;
	}

	public String getItmsNm() {
		return itmsNm;
	}

	public void setItmsNm(String itmsNm) {
		this.itmsNm = itmsNm;
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

}
