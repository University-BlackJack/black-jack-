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

public class signUp extends JPanel {
	private JTextField textField_userName;
	private JPasswordField passwordField;
	private boolean flag_null=false; //null string username or password
	private JPasswordField passwordField_1;
	public signUp() {
		setLayout(null);
		
		JLabel lblUsername = new JLabel("userName");
		lblUsername.setForeground(Color.BLUE);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(94, 158, 69, 14);
		add(lblUsername);
		
		textField_userName = new JTextField();
		textField_userName.setBounds(249, 156, 86, 20);
		add(textField_userName);
		textField_userName.setColumns(10);
		
		JLabel lblPasword = new JLabel("pasword");
		lblPasword.setForeground(Color.BLUE);
		lblPasword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPasword.setBounds(94, 195, 96, 14);
		add(lblPasword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(249, 193, 86, 20);
		add(passwordField);
		
		JLabel lblSignUp = new JLabel("sign up");
		lblSignUp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setBounds(138, 40, 138, 56);
		add(lblSignUp);
		JButton btnSignUp = new JButton("sign UP");
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
		
		JLabel label = new JLabel("pasword");
		label.setBackground(new Color(238, 238, 238));
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Dialog", Font.PLAIN, 15));
		label.setBounds(94, 237, 96, 14);
		add(label);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(249, 235, 86, 20);
		add(passwordField_1);
		
	
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