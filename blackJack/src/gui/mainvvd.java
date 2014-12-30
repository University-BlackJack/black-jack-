package gui;

import java.io.IOException;

public class mainvvd {

	/**
	 * @param args
	 * @throws IOException 
	 */
	  public static BlackJack.Engine engine;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MainScreen main = new MainScreen();
		main.BuildScreen();
		
	        engine= new BlackJack.Engine();
			}

}
