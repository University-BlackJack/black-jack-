package BlackJack;
///////the card class have a number and sit and face and src
public class Card {
	
	private int number;
	private int suit;
	private Boolean face;
	public String src;
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src= src;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getSuit() {
		return suit;
	}
	public void setSuit(int suit) {
		this.suit = suit;
	}
	public Boolean getFace() {
		return face;
	}
	public void setFace(Boolean face) {
		this.face = face;
	}
	public Card() {
		super();
		setNumber(0);
		setSuit(0);
		setFace(true);
	}
	//flip the card
	public void flip(){
		if(!this.face){
		this.face = true;
		}
		else {
		this.face = false;
		} 
		//TODO 
		// ADD Interface Flip Action 
		//Operator + If needed 
	}
	
	
		

}
