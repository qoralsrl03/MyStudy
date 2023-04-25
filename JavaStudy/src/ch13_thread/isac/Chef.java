package ch13_thread.isac;

public class Chef extends Thread {
	private Issac issac = Issac.getInstance();
	EndCook endcook;

	@Override
	public void run() {
		for (int i = 0; i < 15; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			issac.makeToast();

		}
		endcook.finish();
	}
}
