import java.io.Serializable;

public class Fiche implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String word;
	String tWord;
	
	Fiche(){
		
	}
	Fiche(String word, String tword){
		this.word = word;
		this.tWord = tword;
		
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String gettWord() {
		return tWord;
	}
	public void settWord(String tWord) {
		this.tWord = tWord;
	}
	
	
	
	
}