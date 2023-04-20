package minki.submit12;

public class AudioBoard extends Board {
	private String audio;

	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}

	public AudioBoard() {
		super();
	}

	public AudioBoard(int no, String title, String context, String audio) {
		super(no, title, context);
		this.audio = audio;
	}

}
