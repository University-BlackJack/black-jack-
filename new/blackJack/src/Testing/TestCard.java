package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import BlackJack.Card;
import BlackJack.GenericPlayer;
import BlackJack.Hand;

public class TestCard {

	@Test
	public void test() {
		Hand g = new Hand();
		Card a;
		g.initialize();
		a = g.getCard();
		assertEquals(a.getNumber(),0,13);
	//	assertNotNull(s);
		
	}

}
