package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import BlackJack.Card;
import BlackJack.Hand;

public class testingSuit {

	@Test
	public void test() {
		Hand g = new Hand();
		Card a;
		g.initialize();
		a = g.getCard();
		assertEquals(a.getSuit(),0,4);
	}

}
