package gui;



import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.StatementImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class logIn extends JPanel {
	private JTextField textField_userName;
	private JPasswordField passwordField;
	private Connection connect = null; // connect to mysql-server
	private PreparedStatement stmt = null;
	private boolean flag_null=false; //null string username or password
	private boolean flag_login=false; 
	private String UserName_server; 
	private String Password_server;
	private int Score_server; 
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
				
				 String username = null;
				 username=textField_userName.getText();
				 char [] pass =  passwordField.getPassword();
				 String password = null;
				 password = new String(pass);
				 
				 if(!username.equals("")&&!password.equals("")){
					 flag_null=true;
				 }
				 else
				 {
					 JOptionPane.showMessageDialog(null,"Enter User Name and Password.");
				 }
				String sql = "select UserName,Password,Score FROM User;";
				try {
					connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/BlackJack","root","123456");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(connect==null)
					JOptionPane.showMessageDialog(null,"Connect lost ");
				try {
					stmt = (PreparedStatement) connect.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery(sql);
					if(flag_null){
						while(rs.next()){
					         //Retrieve by column name
					         int score_local = rs.getInt("Score");
					         String username_local = rs.getString("UserName");
					         String password_local = rs.getString("Password");
					         if(username_local.equals(username)&&password_local.equals(password)){
					        	 flag_login=true;
					        	 UserName_server = new String(username_local);
					        	 Password_server = new String(password_local);
					        	 Score_server = score_local;
					        	 break;
					         }
					      }
					}
					if(flag_null&&!flag_login){
						JOptionPane.showMessageDialog(null,"Your user name or password is not in a database");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(flag_null&&flag_login)
				{
					Score Score= new Score();
					MainScreen.card.add("Score", Score);
					MainScreen.cardLayot.show(MainScreen.card, "Score");
				}
				
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
