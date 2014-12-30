package gui;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class logIn extends JPanel {
	private JTextField textField_userName;
	private JPasswordField passwordField;
	public logIn() {
		setLayout(null);
	
		JLabel lblNewLabel = new JLabel("userName");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(46, 93, 124, 50);
		add(lblNewLabel);
		
		textField_userName = new JTextField();
		textField_userName.setBounds(239, 112, 86, 20);
		add(textField_userName);
		textField_userName.setColumns(10);
		
		JLabel lblPaswword = new JLabel("paswword");
		lblPaswword.setForeground(Color.BLUE);
		lblPaswword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPaswword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaswword.setBounds(46, 210, 124, 50);
		add(lblPaswword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(239, 225, 86, 20);
		add(passwordField);
		
		JLabel lblLogin = new JLabel("logIn");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(new Color(0, 0, 0));
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogin.setBounds(46, 36, 210, 46);
		add(lblLogin);
		JButton btnEnter = new JButton("enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				        Score Score= new Score();
                
						MainScreen.card.add("Score", Score);
						MainScreen.cardLayot.show(MainScreen.card, "Score");
				
			}
		});
		btnEnter.setBounds(47, 305, 138, 23);
		add(btnEnter);
		JButton btnSignup = new JButton("signUP");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    signUp signUp= new signUp();
	                
					MainScreen.card.add("signUp", signUp);
					MainScreen.cardLayot.show(MainScreen.card, "signUp");
			}
		});
		btnSignup.setBounds(236, 305, 138, 23);
		add(btnSignup);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 0,Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		add(lblNewLabel_1);
		Image  img = new ImageIcon(this.getClass().getResource("/black_1.jpg")).getImage();
		

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		final BufferedImage newImage = resizeImage(img,Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		lblNewLabel_1.setIcon(new ImageIcon(newImage));
		
	
		
		
		
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
