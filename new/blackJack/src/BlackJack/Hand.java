package BlackJack;

import java.util.Random;

//////// a hand class ///////////

public class Hand {

	private Card[] cards;
	private int[] onDeck;

	
	public Hand() {
		super();
		int i=0;
		cards = new Card[52];
		for(i=0;i<cards.length;i++){
			cards[i]= new Card();
		}
		onDeck = new int[52];
		
	}
	//////////// a initialize card from thhe photo to the palyer or deler
	public void initialize(){
		int i=0;
		for (i=0;i<cards.length;i++){
			onDeck[i]=0;
		}
		int suit=0;
		for(i=0;i<cards.length;i++){
			cards[i].setNumber(((i%13)+1));  // Number the cards 
		 
			if(i%13==0)                    //set suits
			{
				suit++;
				
			}
			cards[i].setSuit(suit);
			
			cards[i].src = new String();
			cards[i].setSrc("/cards/"+suit+"_"+((i%13)+1)+".png");
			
			
			cards[i].setFace(true); //All cards are face up
		}
		
	}
	
	public void shuffle(){
		// We don't need it 
	}
	public Card getCard(){
		int avalable;
	    Random randomGenerator = new Random();
		avalable =Math.abs( randomGenerator.nextInt()%52);
		int counter=0;
		for(int i=0;i<onDeck.length;i++){
			if(onDeck[i]==1)
				counter++;
		}
		if(counter==52){
			System.exit(0);
		}
		while (this.onDeck[avalable]==1){
			avalable = Math.abs( randomGenerator.nextInt()%52);
				}
		this.onDeck[avalable]=1; //not avalaible any more
		
		return this.cards[avalable];
	}
	public void  upatePlayerScore(){
		//TODO 
	}
	
	
}