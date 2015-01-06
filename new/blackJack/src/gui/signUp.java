package gui;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class signUp extends JPanel {
	private JTextField textField_userName;
	private JPasswordField passwordField;
	private boolean flag_null=false; //null string username or password
	private JPasswordField passwordField_1;
	public signUp() {
		 Image  img3 = new ImageIcon(this.getClass().getResource("/signup2.png")).getImage();
		setLayout(null);
		
		textField_userName = new JTextField();
		textField_userName.setForeground(Color.DARK_GRAY);
		textField_userName.setFont(new Font("Showcard Gothic", textField_userName.getFont().getStyle(), textField_userName.getFont().getSize() + 8));
		textField_userName.setOpaque(false);
		textField_userName.setBounds(152, 164, 280, 38);
		add(textField_userName);
		textField_userName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.DARK_GRAY);
		passwordField.setFont(new Font("Showcard Gothic", passwordField.getFont().getStyle(), passwordField.getFont().getSize() + 8));
		passwordField.setOpaque(false);
		passwordField.setBounds(152, 219, 280, 38);
		add(passwordField);
		JButton btnSignUp = new JButton("");
		btnSignUp.setOpaque(false);
		btnSignUp.setContentAreaFilled(false);
		btnSignUp.setBorderPainted(false);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql_con con = new sql_con();
				String username = textField_userName.getText();
				char [] pass = passwordField.getPassword();
				char [] pass2 = passwordField_1.getPassword();
				String password = new String(pass);
				String password2 = new String(pass2);
				if(!username.equals("")&&!password.equals("")&&!password2.equals("")&&password.equals(password2)){
					flag_null=true;
				}
				else{
					JOptionPane.showMessageDialog(null,"Enter User Name and Password.");
				}
				
				if(flag_null&&con.Insert_Username(username, password)){
					logIn logIn = new  logIn();
			        MainScreen.card.add("logIn", logIn);
			        MainScreen.cardLayot.show(MainScreen.card, "logIn");
				}
			}
		});
		btnSignUp.setBounds(243, 381, 108, 42);
		add(btnSignUp);
		
		JButton btnCancel = new JButton("");
		Image  img33 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		final BufferedImage newImage22 = resizeImage(img33,50,50);
		btnCancel.setIcon(new ImageIcon(newImage22));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    	logIn logIn = new  logIn();
		          MainScreen.card.add("logIn", logIn);
		  		  MainScreen.cardLayot.show(MainScreen.card, "logIn");
			}
		});
		btnCancel.setBounds(500, 20, 50, 50);
		add(btnCancel);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Showcard Gothic", passwordField_1.getFont().getStyle(), passwordField_1.getFont().getSize() + 8));
		passwordField_1.setForeground(Color.DARK_GRAY);
		passwordField_1.setOpaque(false);
		passwordField_1.setBounds(152, 274, 280, 38);
		add(passwordField_1);
		
	// back ground image sign up
		
		final JLabel lblNewLabel4 = new JLabel("");
		lblNewLabel4.setBounds(20, 20, 530, 414);
		lblNewLabel4.setIcon(new ImageIcon(img3));
		add(lblNewLabel4);
		
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