package gui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class signUp extends JPanel {
	private JTextField textField_firstName;
	private JTextField textField_lastName;
	private JTextField textField_userName;
	private JPasswordField passwordField;
	public signUp() {
		setLayout(null);
		
		JLabel lblFirstName = new JLabel("first name");
		lblFirstName.setForeground(Color.BLUE);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFirstName.setBounds(94, 104, 96, 21);
		add(lblFirstName);
		
		textField_firstName = new JTextField();
		textField_firstName.setBounds(249, 104, 86, 20);
		add(textField_firstName);
		textField_firstName.setColumns(10);
		
		JLabel lblLastname = new JLabel("lastName");
		lblLastname.setForeground(Color.BLUE);
		lblLastname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLastname.setBounds(94, 151, 96, 14);
		add(lblLastname);
		
		textField_lastName = new JTextField();
		textField_lastName.setBounds(249, 148, 86, 20);
		add(textField_lastName);
		textField_lastName.setColumns(10);
		
		JLabel lblUsername = new JLabel("userName");
		lblUsername.setForeground(Color.BLUE);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(94, 201, 69, 14);
		add(lblUsername);
		
		textField_userName = new JTextField();
		textField_userName.setBounds(249, 198, 86, 20);
		add(textField_userName);
		textField_userName.setColumns(10);
		
		JLabel lblPasword = new JLabel("pasword");
		lblPasword.setForeground(Color.BLUE);
		lblPasword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPasword.setBounds(94, 252, 96, 14);
		add(lblPasword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(249, 249, 86, 20);
		add(passwordField);
		
		JLabel lblSignUp = new JLabel("sign up");
		lblSignUp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setBounds(138, 40, 138, 56);
		add(lblSignUp);
		JButton btnSignUp = new JButton("sign UP");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  logIn logIn = new  logIn();
		          MainScreen.card.add("logIn", logIn);
		  		  MainScreen.cardLayot.show(MainScreen.card, "logIn");
			}
		});
		btnSignUp.setBounds(94, 318, 89, 23);
		add(btnSignUp);
		
		JButton btnCancel = new JButton("cancel ");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    	logIn logIn = new  logIn();
		          MainScreen.card.add("logIn", logIn);
		  		  MainScreen.cardLayot.show(MainScreen.card, "logIn");
			}
		});
		btnCancel.setBounds(246, 318, 89, 23);
		add(btnCancel);
		
	
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
