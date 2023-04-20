package minki.submit12;

public class CartoonBoard extends Board{
	private String img;
	
	public CartoonBoard() {
		super();
	}

	public CartoonBoard(int no, String title, String context, String img) {
		super(no, title, context);
		this.img = img;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}


	
}
