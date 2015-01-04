package BlackJack;
//the black jack game 
public class BlackJack {
	public Player player;
	public Dealer dealer;
	public Hand hand_round;
	
	////deal start a hand to player and deler
	public void Deal(){
		player.startHand(hand_round);
		
		dealer.startHand(hand_round);		
	}

/////new game ///////////////////////////////////////////
	public BlackJack() {
		super();
		 player = new Player("Max");
		 dealer =  new Dealer("Dealer");
		 hand_round = new Hand();
	}

}
