package BlackJack;

import gui.mainvvd;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class GenericPlayer {
		public Card[] p_cards;
		public int sum_cards;
		private String name;
		private int currect_cards;
		public int ace_value=0;
		public int score;
		public int scoreBet;
		public GenericPlayer(String name) {
			super();
			this.name=name;
			this.p_cards = new Card[5];
			for(int i=0;p_cards.length<5;i++){
				p_cards[i] =new Card();
			}
			this.setSum_cards(0);
			this.setCurrect_cards(0);
			this.score=100;
			this.scoreBet=0;
			
		}
		public int getSum_cards() {
			return sum_cards;
		}
		public void setSum_cards(int sum_cards) {
			this.sum_cards = sum_cards;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getCurrect_cards() {
			return currect_cards;
		}
		public void setCurrect_cards(int currect_cards) {
			this.currect_cards = currect_cards;
		}
		///hit mithod he hit for the plaer and the deler a card and the value abd update the sum card and the count of card to player
		public String Hit(){
			
			
			Card tmp1 = new Card();
			tmp1 = mainvvd.engine.Game.hand_round.getCard();
			String s = new String();
			s = tmp1.getSrc();
			if(tmp1.getNumber()==1){
				if(this.sum_cards+11>21)
					this.ace_value=1;
					
				else
					this.ace_value=11;
			}
			
			this.currect_cards ++;
			
			if(tmp1.getNumber()==1){
				
				
					this.sum_cards+=this.ace_value;
															
			}
			else if(tmp1.getNumber()>9){
					this.sum_cards+=10;
				}
			else this.sum_cards += tmp1.getNumber();
			
			if(this.sum_cards>21)
					if(this.ace_value==11){
						this.sum_cards-=this.ace_value;
						this.ace_value=1;
						this.sum_cards+=this.ace_value;
					}
			
			return s=tmp1.getSrc();
			
		
		}
		////////aadd card 
		
		public void addCard(Card card){
			this.p_cards[this.currect_cards] = card;
			this.currect_cards++;
			//TODO STOP at 5 CARDS
		}
		public boolean IsBusted(){
			
			if(this.getSum_cards()>21){
			return true;
			}
			else {
			return false;
			}
				
		}
		
		
		
		
}
