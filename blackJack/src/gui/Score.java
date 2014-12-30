package gui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class Score extends JPanel {
	public  static JTextField textField_score_player;
	private static JTextField textField_Sum;
	public static boolean delerWon =false;
	public static boolean palyerWon=false;
	public static boolean play=false;
	
	public Score() {
		
		
		
		setLayout(null);
		textField_score_player = new JTextField();
		textField_score_player.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textField_score_player.setBackground(new Color(255, 0, 0));
		textField_score_player.setBounds(279, 42, 177, 96);
		add(textField_score_player);
		textField_score_player.setColumns(10);
		mainvvd.engine.Game.player.scoreBet=0;
		JButton btnPlay = new JButton("Play");
		btnPlay.setIcon(new ImageIcon("C:\\Users\\moaad sabtan\\Downloads\\paly.jpg"));
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mainvvd.engine.Game.player.score==0){
					JOptionPane.showMessageDialog(null,"you dont have a mony  !!!  ");
					return;
				}
				if(textField_Sum.getText().equals("")){
			JOptionPane.showMessageDialog(null,"you have  to  to put a many !!!  ");

					return;
				}
                hit hit= new hit();
				MainScreen.card.add("hit", hit);
				MainScreen.cardLayot.show(MainScreen.card, "hit");
                //hit.textField.setText(sum);
                String name = String.valueOf(mainvvd.engine.Game.player.getName());
                hit.textField_1.setText(name); 
                
                
			}
		});
		btnPlay.setBounds(32, 496, 178, 149);
		add(btnPlay);
		
		textField_Sum = new JTextField();
		textField_Sum.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textField_Sum.setBackground(Color.RED);
		textField_Sum.setBounds(294, 381, 177, 99);
		add(textField_Sum);
		textField_Sum.setColumns(10);
		
		Score.textField_score_player.setText(""+mainvvd.engine.Game.player.score);
		JButton button = new JButton("10");
		button.setIcon(new ImageIcon("C:\\Users\\moaad sabtan\\Downloads\\10.jpg"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mainvvd.engine.Game.player.score>=mainvvd.engine.Game.player.scoreBet+10){
					mainvvd.engine.Game.player.scoreBet+=10;
					Score.textField_Sum.setText(""+mainvvd.engine.Game.player.scoreBet);
				}
			}
		});
		button.setBounds(31, 173, 178, 156);
		add(button);
		
		JButton button_1 = new JButton("5");
		button_1.setIcon(new ImageIcon("C:\\Users\\moaad sabtan\\Downloads\\5.jpg"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mainvvd.engine.Game.player.score>=mainvvd.engine.Game.player.scoreBet+5){
					mainvvd.engine.Game.player.scoreBet+=5;
					Score.textField_Sum.setText(""+mainvvd.engine.Game.player.scoreBet);
				}
				
			}
		});
		button_1.setBounds(318, 173, 178, 156);
		add(button_1);
		
		JButton button_2 = new JButton("1");
		button_2.setIcon(new ImageIcon("C:\\Users\\moaad sabtan\\Downloads\\1.jpg"));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mainvvd.engine.Game.player.score>=mainvvd.engine.Game.player.scoreBet+1){
					mainvvd.engine.Game.player.scoreBet+=1;
					Score.textField_Sum.setText(""+mainvvd.engine.Game.player.scoreBet);
				}
			}
		});
		button_2.setBounds(652, 173, 178, 156);
		add(button_2);
		
		JButton btnClose = new JButton("close");
		btnClose.setIcon(new ImageIcon("C:\\Users\\moaad sabtan\\Downloads\\close.png"));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			}
		});
		btnClose.setBounds(788, 499, 190, 143);
		add(btnClose);
		
		JLabel lblYourMoney = new JLabel("your money ");
		lblYourMoney.setForeground(Color.BLUE);
		lblYourMoney.setBackground(Color.BLUE);
		lblYourMoney.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblYourMoney.setVisible(true);
		lblYourMoney.setBounds(51, 42, 177, 96);
		add(lblYourMoney);
		JLabel lblNewLabel = new JLabel("hit money ");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setVisible(true);
		lblNewLabel.setBounds(51, 381, 177, 96);
		add(lblNewLabel);
		
		
		
		JLabel lblNewLabe = new JLabel("");
		lblNewLabe.setBounds(0, 0,Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		add(lblNewLabe);
		Image  img = new ImageIcon(this.getClass().getResource("/black_1.jpg")).getImage();
		

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		final BufferedImage newImage = resizeImage(img,Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		lblNewLabe.setIcon(new ImageIcon(newImage));
		
		
	
	
	}
	
	
	
	
	
	public static BufferedImage resizeImage(final Image image, int width, int height) {
        final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        final Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setComposite(AlphaComposite.Src);
        graphics2D.drawImage(image, 0, 0, width, height, null);
        graphics2D.dispose();
 
        return bufferedImage;
    }
}
