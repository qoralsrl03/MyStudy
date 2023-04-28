package ch14_jdbc_jsp.vo;

public class WordGameVO {
	private String words;

	
	@Override
	public String toString() {
		return "WordGameVO [words=" + words + "]";
	}

	public WordGameVO() {}

	public WordGameVO(String words) {
		super();
		this.words = words;
	}

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}
	
	
}
