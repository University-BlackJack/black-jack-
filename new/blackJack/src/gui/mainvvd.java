package gui;

import gui.MainScreen;

import java.awt.CardLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
