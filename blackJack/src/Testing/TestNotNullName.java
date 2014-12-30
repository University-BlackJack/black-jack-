package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import BlackJack.Card;
import BlackJack.GenericPlayer;
import BlackJack.Hand;

public class TestNotNullName {

	@Test
	public void test() {
		GenericPlayer g = new GenericPlayer("moaad");
		String s = g.getName();
		assertNotNull(s);
		
	
		
	}

}
