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
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Score extends JPanel {
	public  static JTextField textField_score_player;
	private static JTextField textField_Sum;
	public static boolean delerWon =false;
	public static boolean palyerWon=false;
	public static boolean play=false;
	
	public Score() {
		
		
		
		setLayout(null);
		textField_score_player = new JTextField();
		textField_score_player.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textField_score_player.setOpaque(false);
		textField_score_player.setForeground(SystemColor.activeCaptionBorder);
		textField_score_player.setHorizontalAlignment(SwingConstants.CENTER);
		textField_score_player.setFont(new Font("David", Font.BOLD, 30));
		textField_score_player.setBackground(Color.WHITE);
		textField_score_player.setBounds(451, 74, 99, 48);
		add(textField_score_player);
		textField_score_player.setColumns(10);
		mainvvd.engine.Game.player.scoreBet=0;
		JButton btnPlay = new JButton("Play");
		btnPlay.setFont(new Font("Poor Richard", btnPlay.getFont().getStyle(), btnPlay.getFont().getSize() + 15));
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
		btnPlay.setBounds(52, 468, 178, 55);
		add(btnPlay);
		
		textField_Sum = new JTextField();
		textField_Sum.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Sum.setText("0");
		textField_Sum.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textField_Sum.setOpaque(false);
		textField_Sum.setForeground(SystemColor.activeCaptionBorder);
		textField_Sum.setFont(new Font("David", Font.BOLD, 30));
		textField_Sum.setBackground(Color.WHITE);
		textField_Sum.setBounds(112, 389, 64, 48);
		add(textField_Sum);
		textField_Sum.setColumns(10);
		
		Score.textField_score_player.setText(""+mainvvd.engine.Game.player.score);
		JButton button = new JButton("10");
		Image img2;
		img2 = new ImageIcon(this.getClass().getResource("/Bet10.png")).getImage();
		final BufferedImage newImage2 = resizeImage(img2,150,150);
		button.setIcon(new ImageIcon(newImage2));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mainvvd.engine.Game.player.score>=mainvvd.engine.Game.player.scoreBet+10){
					mainvvd.engine.Game.player.scoreBet+=10;
					Score.textField_Sum.setText(""+mainvvd.engine.Game.player.scoreBet);
				}
			}
		});
		button.setBounds(186, 173, 150, 150);
		add(button);
		
		JButton button_1 = new JButton("5");
		img2 = new ImageIcon(this.getClass().getResource("/bet5.png")).getImage();
		final BufferedImage newImage3 = resizeImage(img2,150,150);
		button_1.setIcon(new ImageIcon(newImage3));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mainvvd.engine.Game.player.score>=mainvvd.engine.Game.player.scoreBet+5){
					mainvvd.engine.Game.player.scoreBet+=5;
					Score.textField_Sum.setText(""+mainvvd.engine.Game.player.scoreBet);
				}
				
			}
		});
		button_1.setBounds(346, 173, 150, 150);
		add(button_1);
		
		JButton button_2 = new JButton("1");
		img2 = new ImageIcon(this.getClass().getResource("/Bet1.png")).getImage();
		final BufferedImage newImage4 = resizeImage(img2,150,150);
		button_2.setIcon(new ImageIcon(newImage4));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mainvvd.engine.Game.player.score>=mainvvd.engine.Game.player.scoreBet+1){
					mainvvd.engine.Game.player.scoreBet+=1;
					Score.textField_Sum.setText(""+mainvvd.engine.Game.player.scoreBet);
				}
			}
		});
		button_2.setBounds(503, 173, 150, 150);
		add(button_2);
		
		JButton btnClose = new JButton("close");
		btnClose.setFont(new Font("Poor Richard", Font.BOLD | Font.ITALIC, 26));
		btnClose.setIcon(new ImageIcon("C:\\Users\\moaad sabtan\\Downloads\\close.png"));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			}
		});
		btnClose.setBounds(52, 534, 178, 55);
		add(btnClose);
		
		JLabel lblNewLabel_2 = new JLabel("Choose Bet");
		lblNewLabel_2.setFont(new Font("Poor Richard", Font.BOLD, 26));
		lblNewLabel_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(28, 230, 124, 26);
		lblNewLabel_2.setVisible(true);
		add(lblNewLabel_2);
		
		JLabel lblYourMoney = new JLabel("Total Budget");
		lblYourMoney.setForeground(SystemColor.textHighlight);
		lblYourMoney.setBackground(Color.WHITE);
		lblYourMoney.setFont(new Font("Poor Richard", Font.BOLD, 26));
		lblYourMoney.setVisible(true);
		lblYourMoney.setBounds(274, 72, 167, 48);
		add(lblYourMoney);
		JLabel lblNewLabel = new JLabel("Bet ");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Poor Richard", Font.BOLD, 26));
		lblNewLabel.setVisible(true);
		lblNewLabel.setBounds(52, 387, 107, 48);
		add(lblNewLabel);
		
		
		
		JLabel lblNewLabe = new JLabel("");
		lblNewLabe.setFont(new Font("Poor Richard", lblNewLabe.getFont().getStyle(), lblNewLabe.getFont().getSize() + 15));
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
