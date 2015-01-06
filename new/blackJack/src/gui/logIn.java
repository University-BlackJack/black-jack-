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
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class logIn extends JPanel {
	private JTextField textField_userName;
	private JPasswordField passwordField;
	private boolean flag_null=false; //null string username or password
	public  static String UserName_server; 
	public  static int Score_server; 
	
	public logIn() {
		 Image  img3 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		
		setLayout(null);
		
		textField_userName = new JTextField(){
			@Override public void setBorder(Border border) {
		        // No!
		    }
		};
		textField_userName.setBorder(null);
		textField_userName.setFont(new Font("Showcard Gothic", textField_userName.getFont().getStyle(), textField_userName.getFont().getSize() + 9));
		textField_userName.setForeground(Color.WHITE);
		textField_userName.setOpaque(false);
		 
		textField_userName.setBounds(126, 124, 226, 45);
		add(textField_userName);
		textField_userName.setColumns(10);
		
		passwordField = new JPasswordField(){
			@Override public void setBorder(Border border) {
		        // No!
		    }
		};
		passwordField.setBorder(null);
		passwordField.setForeground(Color.WHITE);
		passwordField.setFont(new Font("Arial Black", Font.PLAIN, 20));
		passwordField.setOpaque(false);
		passwordField.setBounds(126, 186, 226, 45);
		add(passwordField);
		JButton btnSignup = new JButton("");
		btnSignup.setOpaque(false);
		btnSignup.setContentAreaFilled(false);
		btnSignup.setBorderPainted(false);
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    signUp signUp= new signUp();
	                
					MainScreen.card.add("signUp", signUp);
					MainScreen.cardLayot.show(MainScreen.card, "signUp");
			}
		});
		btnSignup.setBounds(220, 318, 110, 30);
		add(btnSignup);
		JButton btnEnter = new JButton("");
	
		btnEnter.setOpaque(false);
		btnEnter.setContentAreaFilled(false);
		btnEnter.setBorderPainted(false);
		btnEnter.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent arg0) {
				String username = null;
				 username=textField_userName.getText();
				 char [] pass =  passwordField.getPassword();
				 String password = null;
				 password = new String(pass);
				 sql_con con = new sql_con();
				 if(!username.equals("")&&!password.equals("")){
					 flag_null=true;
				 }
				 else
				 {
					 JOptionPane.showMessageDialog(null,"Enter User Name and Password.");
				 }
				if(flag_null&&con.Check_UserName_Pass(username,password))
				{
					mainvvd.engine.Game.player.name=con.getUserName_server();
					mainvvd.engine.Game.player.score=con.getScore();
					Score Score= new Score();
					MainScreen.card.add("Score", Score);
					MainScreen.cardLayot.show(MainScreen.card, "Score");
				}
				
			}
		});
		btnEnter.setBounds(77, 261, 281, 48);
		add(btnEnter);
		Image  img = new ImageIcon(this.getClass().getResource("/black_1.jpg")).getImage();
		

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		final BufferedImage newImage = resizeImage(img,Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		final JLabel lblNewLabel4 = new JLabel("");
		lblNewLabel4.setBounds(20, 20, 523, 414);
		lblNewLabel4.setIcon(new ImageIcon(img3));
		add(lblNewLabel4);
		textField_userName.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				 JOptionPane.showMessageDialog(null,"Player Busted  !!,Start a New Hand ");
				
			
			}

			@SuppressWarnings("deprecation")
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				Image img4 =  img4 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();;
				if( (textField_userName.getText().length()!=0 ) && ( passwordField.getText().length()!=0 ) ){
				   img4 = new ImageIcon(this.getClass().getResource("/login3.png")).getImage();
				}
				else if( (textField_userName.getText().length()!=0) &&(passwordField.getText().length()==0 )){
					  img4 = new ImageIcon(this.getClass().getResource("/login2.png")).getImage();
				}
				else if( (textField_userName.getText().length()==0) &&(passwordField.getText().length()!=0 )){
					  img4 = new ImageIcon(this.getClass().getResource("/login4.png")).getImage();
				}
				else if( (textField_userName.getText().length()==0) &&(passwordField.getText().length()==0 )){
					  img4 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
				}
					
					lblNewLabel4.setIcon(new ImageIcon(img4));
					lblNewLabel4.repaint();
				
				
					
				
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				
				Image img4 =  img4 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();;
				if( (textField_userName.getText().length()!=0 ) && ( passwordField.getText().length()!=0 ) ){
				   img4 = new ImageIcon(this.getClass().getResource("/login3.png")).getImage();
				}
				else if( (textField_userName.getText().length()!=0) &&(passwordField.getText().length()==0 )){
					  img4 = new ImageIcon(this.getClass().getResource("/login2.png")).getImage();
				}
				else if( (textField_userName.getText().length()==0) &&(passwordField.getText().length()!=0 )){
					  img4 = new ImageIcon(this.getClass().getResource("/login4.png")).getImage();
				}
				else if( (textField_userName.getText().length()==0) &&(passwordField.getText().length()==0 )){
					  img4 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
				}
					
					lblNewLabel4.setIcon(new ImageIcon(img4));
					lblNewLabel4.repaint();
			}
			
		});
		passwordField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent e) {
				
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				Image img4 =  img4 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();;
				if( (textField_userName.getText().length()!=0 ) && ( passwordField.getText().length()!=0 ) ){
				   img4 = new ImageIcon(this.getClass().getResource("/login3.png")).getImage();
				}
				else if( (textField_userName.getText().length()!=0) &&(passwordField.getText().length()==0 )){
					  img4 = new ImageIcon(this.getClass().getResource("/login2.png")).getImage();
				}
				else if( (textField_userName.getText().length()==0) &&(passwordField.getText().length()!=0 )){
					  img4 = new ImageIcon(this.getClass().getResource("/login4.png")).getImage();
				}
				else if( (textField_userName.getText().length()==0) &&(passwordField.getText().length()==0 )){
					  img4 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
				}
					
					lblNewLabel4.setIcon(new ImageIcon(img4));
					lblNewLabel4.repaint();
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				Image img4 =  img4 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();;
				if( (textField_userName.getText().length()!=0 ) && ( passwordField.getText().length()!=0 ) ){
				   img4 = new ImageIcon(this.getClass().getResource("/login3.png")).getImage();
				}
				else if( (textField_userName.getText().length()!=0) &&(passwordField.getText().length()==0 )){
					  img4 = new ImageIcon(this.getClass().getResource("/login2.png")).getImage();
				}
				else if( (textField_userName.getText().length()==0) &&(passwordField.getText().length()!=0 )){
					  img4 = new ImageIcon(this.getClass().getResource("/login4.png")).getImage();
				}
				else if( (textField_userName.getText().length()==0) &&(passwordField.getText().length()==0 )){
					  img4 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
				}
					
					lblNewLabel4.setIcon(new ImageIcon(img4));
					lblNewLabel4.repaint();
				
			}
			
			
		});
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 0,Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		add(lblNewLabel_1);
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