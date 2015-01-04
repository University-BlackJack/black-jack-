package gui;


import gui.main;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainScreen extends JFrame  {
	public static JFrame frm;
	
	/**
	 * constructor of main screen 
	 */
	public MainScreen() {
	}

	public static CardLayout cardLayot;
	public static JPanel card = new JPanel();
	
	//public static Object contentPane;
	/**
	 * Creante the main screen jframe 
	 * @throws IOException
	 */
	public static void BuildScreen() throws IOException
	{
		

		frm= new JFrame();
		JPanel contentPane = (JPanel)frm.getContentPane();
		card.setLayout(cardLayot = new CardLayout());

		main main= new main();
	
		card.add("main", main);
		cardLayot.show(card, "main");
		contentPane.add(card);
		frm.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		frm.setVisible(true);
		frm.setResizable(true);
		
		frm.setLocation(0, 0);
		//frm.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		frm.setDefaultCloseOperation(frm.EXIT_ON_CLOSE);
	
		
	}

	public static JPanel getCard() {
		return card;
	}

	public static void setCard(JPanel card) {
		MainScreen.card = card;
		
	}
	
	

}