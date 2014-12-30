package gui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class main extends JPanel {
	  private BufferedImage image;

	public main() throws HeadlessException, IOException {
	
		//setBackground(Color.GRAY);
		//////////player buottom/////////////////
		JButton btnPaly = new JButton("Play");
		btnPaly.setBounds(465, 388, 535, 140);
	//	btnPaly.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		btnPaly.setBackground(Color.WHITE);
		Image  img2 = new ImageIcon(this.getClass().getResource("/play-1.png")).getImage();
		final BufferedImage newImage2 = resizeImage(img2,555, 150);
		btnPaly.setIcon(new ImageIcon(newImage2));
		
		btnPaly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					mainvvd.engine.Creategame();
	                String sum = String.valueOf(mainvvd.engine.Game.player.getSum_cards());
	                
//	                hit hit= new hit();
//					MainScreen.card.add("hit", hit);
//					MainScreen.cardLayot.show(MainScreen.card, "hit");
//	                //hit.textField.setText(sum);
//	                String name = String.valueOf(mainvvd.engine.Game.player.getName());
//	                hit.textField_1.setText(name); 
	                
	                
	                //30/12/14 to log in 
	       //         Score Score= new Score();
	                
			//		MainScreen.card.add("Score", Score);
			//		MainScreen.cardLayot.show(MainScreen.card, "Score");
	          logIn logIn = new  logIn();
	          MainScreen.card.add("logIn", logIn);
	  		  MainScreen.cardLayot.show(MainScreen.card, "logIn");
	                
	                 
			}
		});
		setLayout(null);
		add(btnPaly);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0,Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		add(lblNewLabel);
		Image  img = new ImageIcon(this.getClass().getResource("/black_1.jpg")).getImage();
		

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		final BufferedImage newImage = resizeImage(img,Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		lblNewLabel.setIcon(new ImageIcon(newImage));
		
		//1440*1920
		
	}
	////////////////resizeImage mithod////////////////////
	public static BufferedImage resizeImage(final Image image, int width, int height) {
        final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        final Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setComposite(AlphaComposite.Src);
        graphics2D.drawImage(image, 0, 0, width, height, null);
        graphics2D.dispose();
 
        return bufferedImage;
    }
}
