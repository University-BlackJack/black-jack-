package gui;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
/////hit class gui 
public class hit extends JPanel  {
	public static JTextField textField;
	public  JTextField textField_1;
	public static  boolean to1= false;
	public static  int to2= 0;
	private static JTextField textField_score_deler;
	public static boolean delerWon =false;
	public static boolean palyerWon=false;
	public hit() {
		setLayout(null);
		mainvvd.engine.Game.player.setSum_cards(0);
		mainvvd.engine.Game.dealer.setSum_cards(0);
		mainvvd.engine.Game.player.setCurrect_cards(0);
	////////stand puttom to next itration  to equal with deler //////
		
		

		JLabel lblScore = new JLabel("Score");
		lblScore.setForeground(Color.WHITE);
		lblScore.setFont(new Font("Poor Richard", lblScore.getFont().getStyle(), lblScore.getFont().getSize() + 10));
		lblScore.setBounds(795, 665, 116, 39);
		add(lblScore);
		
		textField = new JTextField();
		textField.setForeground(SystemColor.activeCaptionBorder);
		textField.setOpaque(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("David", textField.getFont().getStyle(), textField.getFont().getSize() + 10));
		textField.setBackground(Color.WHITE);
		textField.setBounds(953, 668, 86, 39);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblPlayerName = new JLabel("Player Name ");
		lblPlayerName.setForeground(Color.WHITE);
		lblPlayerName.setFont(new Font("Poor Richard", lblPlayerName.getFont().getStyle(), lblPlayerName.getFont().getSize() + 10));
		lblPlayerName.setBounds(795, 730, 116, 57);
		add(lblPlayerName);
		
		textField_1 = new JTextField();
		textField_1.setForeground(SystemColor.activeCaptionBorder);
		textField_1.setOpaque(false);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("David", textField_1.getFont().getStyle(), textField_1.getFont().getSize() + 10));
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(953, 742, 86, 39);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblS = new JLabel("");
		Image  img = new ImageIcon(this.getClass().getResource("/deler.jpg")).getImage();
		lblS.setIcon(new ImageIcon(img));
		lblS.setBounds(600, 11, 270, 170);
		add(lblS);
		final JLabel label3 = new JLabel("New label");
		label3.setVisible(false);
		label3.setBounds(539, 523, 100, 119);
		add(label3);

		
		
		final JLabel label4 = new JLabel("New label");
		label4.setVisible(false);
		label4.setBounds(641, 523, 100, 119);
		add(label4);
		
		final JLabel label5 = new JLabel("New label");
		label5.setVisible(false);
		label5.setBounds(739, 523, 100, 119);
		add(label5);
	
		
		final JLabel label1 = new JLabel("player_first_card");
		label1.setVisible(false);
		label1.setBounds(339, 523, 100, 119);
		add(label1);
		//Card card1 = new Card();
	
		
		final JLabel lblDelerfirstcard1 = new JLabel("deler_first_card");
		lblDelerfirstcard1.setBounds(812, 209, 100, 119);
		add(lblDelerfirstcard1);
		
		final JLabel lblDelerSecondCard = new JLabel("deler_first_card");
		lblDelerSecondCard.setBounds(710, 209, 100, 119);
		add(lblDelerSecondCard);
		
		final JLabel label2 = new JLabel("player_first_card");
		label2.setVisible(false);
		label2.setBounds(439, 523, 100, 119);
		add(label2);
		
		final JLabel lblLabeCardThreeDeler = new JLabel("label3");
		lblLabeCardThreeDeler.setVisible(false);
		lblLabeCardThreeDeler.setBounds(607, 209, 100, 119);
		add(lblLabeCardThreeDeler);
		final JLabel lblNewLabefourCard = new JLabel("New label");
		lblNewLabefourCard.setVisible(false);
		lblNewLabefourCard.setBounds(504, 209, 100, 119);
		add(lblNewLabefourCard);
		

		
		guiautoHit(label1,label2);
		guiautoHit2(lblDelerfirstcard1,lblDelerSecondCard);
		JButton btnNewButton = new JButton("Stand");
		//btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sql_con con = new sql_con();
				if(to2== 1){
					return;
				}
//					if(mainvvd.engine.Game.dealer.getSum_cards()>mainvvd.engine.Game.player.getSum_cards()){
//						 JOptionPane.showMessageDialog(null,"you deler win   ");
//						 return;
//					}
//					else{
//						 JOptionPane.showMessageDialog(null,"you player  win   ");
//					}
//					return;
//				}
//				  String s; 
//					s=mainvvd.engine.Game.dealer.Hit();
//					Image img2 = new ImageIcon(this.getClass().getResource(s)).getImage();
//					final BufferedImage newImage22 = resizeImage(img2,97,119);
//					label2.setIcon(new ImageIcon(newImage22));
					
					
				
				// if(mainvvd.engine.Game.player.getSum_cards()>mainvvd.engine.Game.dealer.getSum_cards()){
			//		 JOptionPane.showMessageDialog(null,"you win  next hand!!!  ");
				//	 return;
				// }
		//		 JOptionPane.showMessageDialog(null,"lose  ");
				String s =new String();
				s=mainvvd.engine.Game.dealer.Hit();
				
//			System.out.printf( "\n %s",s); 
	
				lblDelerSecondCard.setVisible(true);
				Image  img2 = new ImageIcon(this.getClass().getResource(s)).getImage();
			//	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
				final BufferedImage newImage = resizeImage(img2,97,119);
				lblDelerSecondCard.setIcon(new ImageIcon(newImage));
				if(mainvvd.engine.Game.dealer.getSum_cards()<17){
					s=mainvvd.engine.Game.dealer.Hit();
					lblLabeCardThreeDeler.setVisible(true);
					  img2 = new ImageIcon(this.getClass().getResource(s)).getImage();
				//	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
					final BufferedImage newImage2 = resizeImage(img2,97,119);
					lblLabeCardThreeDeler.setIcon(new ImageIcon(newImage2));
						
				}
				if(mainvvd.engine.Game.dealer.getSum_cards()<17){
					s=mainvvd.engine.Game.dealer.Hit();
					lblNewLabefourCard.setVisible(true);
					  img2 = new ImageIcon(this.getClass().getResource(s)).getImage();
				//	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
					final BufferedImage newImage2 = resizeImage(img2,97,119);
					lblNewLabefourCard.setIcon(new ImageIcon(newImage2));
						
				}
				
				  hit.textField_score_deler.setText("" + mainvvd.engine.Game.dealer.getSum_cards());
				  if(mainvvd.engine.Game.dealer.getSum_cards()==mainvvd.engine.Game.player.getSum_cards()){
				    	
				    	 JOptionPane.showMessageDialog(null,"Draw,Start a New Hand ");
				    	 to2=1;
						return;
				    	
				    }
				  if(mainvvd.engine.Game.dealer.getSum_cards()>21){
					  int score = mainvvd.engine.Game.player.score+(mainvvd.engine.Game.player.scoreBet*2);
					  con.UpDate_Score(mainvvd.engine.Game.player.name, score);
				    	 JOptionPane.showMessageDialog(null,"Dealer Busted,Start a New Hand "+mainvvd.engine.Game.player.scoreBet*2+" score");
				    	 mainvvd.engine.Game.player.score+=(mainvvd.engine.Game.player.scoreBet*2);
				    	 to2=1;
						return;
				    	
				    }
				  
						if(mainvvd.engine.Game.dealer.getSum_cards()>mainvvd.engine.Game.player.getSum_cards()){
							 int score = mainvvd.engine.Game.player.score-(mainvvd.engine.Game.player.scoreBet);
							  con.UpDate_Score(mainvvd.engine.Game.player.name, score);
							 JOptionPane.showMessageDialog(null,"Dealer Wins,Start a New Hand ");
							 mainvvd.engine.Game.player.score-=mainvvd.engine.Game.player.scoreBet;
							 
						}
						else{
							 int score = mainvvd.engine.Game.player.score+(mainvvd.engine.Game.player.scoreBet*2);
							  con.UpDate_Score(mainvvd.engine.Game.player.name, score);
							 JOptionPane.showMessageDialog(null,"Player Wins,Start a New Hand "+mainvvd.engine.Game.player.scoreBet*2);
							 mainvvd.engine.Game.player.score+=(mainvvd.engine.Game.player.scoreBet*2);
						}
						to2=1;
						return;
					
		}
		});
		
		btnNewButton.setBounds(37, 209, 145, 45);
		add(btnNewButton);
		
		/////////hit buttom to player ////////////////
		JButton btnHit = new JButton("Hit");
		btnHit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(to2== 1){
					return;
				}

				if(mainvvd.engine.Game.player.IsBusted()){
					to2=1;
					return;
					
				}
				sql_con con = new sql_con();
				if(mainvvd.engine.Game.player.getCurrect_cards()==2){
					
					
					String s =new String();
					s=mainvvd.engine.Game.player.Hit();
				//System.out.printf( "\n %s",s); 
					label3.setVisible(true);
					Image  img2 = new ImageIcon(this.getClass().getResource(s)).getImage();
					Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
					final BufferedImage newImage = resizeImage(img2,100,119);
					label3.setIcon(new ImageIcon(newImage));
					  hit.textField.setText("" + mainvvd.engine.Game.player.getSum_cards());
		
					
					  if(mainvvd.engine.Game.player.IsBusted()==true){
						  int score = mainvvd.engine.Game.player.score-mainvvd.engine.Game.player.scoreBet;
						  con.UpDate_Score(mainvvd.engine.Game.player.name, score);
							 JOptionPane.showMessageDialog(null,"Player Busted  !!,Start a New Hand ");
							 mainvvd.engine.Game.player.stand();
							 mainvvd.engine.Game.player.score-=mainvvd.engine.Game.player.scoreBet;

							 to2=1;
							return;
						}
					  return ;
				}
				
				if(mainvvd.engine.Game.player.getCurrect_cards()==3){
					String s =new String();
					s=mainvvd.engine.Game.player.Hit();
				System.out.printf( "\n %s",s); 
					label4.setVisible(true);
					Image  img2 = new ImageIcon(this.getClass().getResource(s)).getImage();
					Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
					final BufferedImage newImage = resizeImage(img2,100,119);
					label4.setIcon(new ImageIcon(newImage));
					  hit.textField.setText("" + mainvvd.engine.Game.player.getSum_cards());
					  if(mainvvd.engine.Game.player.IsBusted()==true){
						  int score = mainvvd.engine.Game.player.score-mainvvd.engine.Game.player.scoreBet;
						  con.UpDate_Score(mainvvd.engine.Game.player.name, score);
						  JOptionPane.showMessageDialog(null,"Player Busted  !!,Start a New Hand ");
							 mainvvd.engine.Game.player.stand();
							 mainvvd.engine.Game.player.score-=mainvvd.engine.Game.player.scoreBet;

							 to2=1;
							return;
						}
					  return ;
				}
				if(mainvvd.engine.Game.player.getCurrect_cards()==4){
					String s =new String();
					s=mainvvd.engine.Game.player.Hit();
				System.out.printf( "\n %s",s); 
					label5.setVisible(true);
					Image  img2 = new ImageIcon(this.getClass().getResource(s)).getImage();
					Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
					final BufferedImage newImage = resizeImage(img2,100,119);
					label5.setIcon(new ImageIcon(newImage));
					  hit.textField.setText("" + mainvvd.engine.Game.player.getSum_cards());
					  if(mainvvd.engine.Game.player.IsBusted()==true){
						  JOptionPane.showMessageDialog(null,"Player Busted  !!,Start a New Hand ");
							 mainvvd.engine.Game.player.stand();
							 mainvvd.engine.Game.player.score-=mainvvd.engine.Game.player.scoreBet;

							 to2=1;
							return;
						}
					 
					  return ;
				}
				
				
				
			}
		});
		btnHit.setBounds(37, 287, 145, 45);
		add(btnHit);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(482, 662, 270, 170);
		Image  img3 = new ImageIcon(this.getClass().getResource("/player.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img3));
		add(lblNewLabel);
		
		JLabel lblDelerScore = new JLabel("Dealer Score ");
		lblDelerScore.setFont(new Font("Poor Richard", lblDelerScore.getFont().getStyle(), lblDelerScore.getFont().getSize() + 10));
		lblDelerScore.setForeground(Color.WHITE);
		lblDelerScore.setBounds(176, 51, 132, 33);
		add(lblDelerScore);
		
		textField_score_deler = new JTextField();
		textField_score_deler.setHorizontalAlignment(SwingConstants.CENTER);
		textField_score_deler.setForeground(SystemColor.activeCaption);
		textField_score_deler.setOpaque(false);
		textField_score_deler.setFont(new Font("David", textField_score_deler.getFont().getStyle(), textField_score_deler.getFont().getSize() + 10));
		textField_score_deler.setBackground(Color.WHITE);
		textField_score_deler.setBounds(305, 51, 51, 33);
		add(textField_score_deler);
		textField_score_deler.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("New Hand");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//	guiautoHit(label1,label2);
			//	guiautoHit2(lblDelerfirstcard1,lblDelerSecondCard);
				if( to2==0){
					  return;
				}
				
				//  JOptionPane.showMessageDialog(null," A new Bit to game   ");

				label1.setVisible(false);
				label2.setVisible(false);
				lblDelerfirstcard1.setVisible(false);
				lblDelerSecondCard.setVisible(false);
				label5.setVisible(false);
				label4.setVisible(false);
				label3.setVisible(false);
				to2=0;
				
		//		JOptionPane.showMessageDialog(null," A new Bit to game   ");
				   Score Score= new Score();
	                
					MainScreen.card.add("Score", Score);
					MainScreen.cardLayot.show(MainScreen.card, "Score");
	                
				mainvvd.engine.Game.player.ace_value=0;
				 mainvvd.engine.Game.player.setCurrect_cards(0);
				 mainvvd.engine.Game.player.setSum_cards(0);
				 mainvvd.engine.Game.dealer.setSum_cards(0);
				 textField_score_deler.setText("0");
				 hit.textField.setText("0");
				 
				guiautoHit(label1,label2);
				guiautoHit2(lblDelerfirstcard1,lblDelerSecondCard);

				

				
			}
		});
		btnNewButton_1.setBounds(37, 372, 145, 45);
		add(btnNewButton_1);
		
		/*JLabel label = new JLabel("");
		Image  img3 = new ImageIcon(this.getClass().getResource("/player.jpg")).getImage();
		lblS.setIcon(new ImageIcon(img3));
		label.setBounds(483, 539, 270, 170);
		add(label);
		*/
		JLabel lblNewLabe = new JLabel("");
		lblNewLabe.setBounds(10, 0,Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		add(lblNewLabe);
		Image  img1 = new ImageIcon(this.getClass().getResource("/black_1.jpg")).getImage();
		

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		final BufferedImage newImage = resizeImage(img1,Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		lblNewLabe.setIcon(new ImageIcon(newImage));
		
		
	
		
		
		
		
		  
		
	}
	//////////function that resizeImage //////////////////////
	public static BufferedImage resizeImage(final Image image, int width, int height) {
        final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        final Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setComposite(AlphaComposite.Src);
        graphics2D.drawImage(image, 0, 0, width, height, null);
        graphics2D.dispose();
 
        return bufferedImage;
    }
	///////outo hit to 2 card to player////////////////////
	public  void  guiautoHit(JLabel label1, JLabel label2){
		
			String s =new String();
			s=mainvvd.engine.Game.player.Hit();
			
	//	System.out.printf( "\n %s",s); 
			label1.setVisible(true);
			Image  img2 = new ImageIcon(this.getClass().getResource(s)).getImage();
		//	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			final BufferedImage newImage = resizeImage(img2,97,119);
			label1.setIcon(new ImageIcon(newImage));
			  hit.textField.setText("" + mainvvd.engine.Game.player.getSum_cards());
			  
			  
			
			
				
				s=mainvvd.engine.Game.player.Hit();
		//	System.out.printf( "\n %s",s); 
				label2.setVisible(true);
				  img2 = new ImageIcon(this.getClass().getResource(s)).getImage();
				//Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
				final BufferedImage newImage2 = resizeImage(img2,97,119);
				label2.setIcon(new ImageIcon(newImage2));
				  hit.textField.setText("" + mainvvd.engine.Game.player.getSum_cards());
				  return ;
			
	}
	public  void  guiautoHit2(JLabel label1, JLabel label2){
		
		String s =new String();
		s=mainvvd.engine.Game.dealer.Hit();
		
//	System.out.printf( "\n %s",s); 
		label1.setVisible(true);
		Image  img2 = new ImageIcon(this.getClass().getResource(s)).getImage();
	//	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		final BufferedImage newImage = resizeImage(img2,97,119);
		label1.setIcon(new ImageIcon(newImage));
		 // hit.textField.setText("" + mainvvd.engine.Game.player.getSum_cards());
		  
		  
		
		
			
			

			label2.setVisible(true);
			
			  img2 = new ImageIcon(this.getClass().getResource("/carddown.jpg")).getImage();
			//Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			final BufferedImage newImage2 = resizeImage(img2,97,119);
			label2.setIcon(new ImageIcon(newImage2));
		//	  hit.textField.setText("" + mainvvd.engine.Game.player.getSum_cards());
	
			  return ;
		
}
}
