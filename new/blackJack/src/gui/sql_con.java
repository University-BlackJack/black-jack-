package gui;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import java.security.*;

public class sql_con {
	private String Server_url ="jdbc:mysql://sql3.freemysqlhosting.net/sql362883";
	private String Server_user="sql362883";
	private String Server_pass="wN8!qU1*";
	private Connection connect = null;
	private String UserName_server = null;
	private int Score;
	public sql_con() {
		super();
	}
	private boolean Connecting(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connect = (Connection) DriverManager.getConnection(Server_url,Server_user,Server_pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(this.connect==null){
			JOptionPane.showMessageDialog(null,"Connect lost ");
			return false;
		}
		return true;
	}
	
	
	public boolean Check_UserName_Pass(String username,String password){
		boolean flag_login = false;
		if(!this.Connecting())
			return false;
		String sql = "select UserName,Password,Score FROM User;";
		try {
			PreparedStatement stmt = (PreparedStatement) this.connect.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
			         int score = rs.getInt("Score");
			         String username_local = rs.getString("UserName");
			         String password_local = rs.getString("Password");
			         if(username_local.equals(MD5(username))&&password_local.equals(MD5(password))){
			        	 flag_login=true;
			        	 this.UserName_server = new String(username);
			        	 this.Score= score;
			        	 break;
			         }
			      }
			
			if(!flag_login){
				JOptionPane.showMessageDialog(null,"Your user name or password is not in a database");
				return false;
			}
			rs.close();
			stmt.close();
			this.connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	public String getUserName_server() {
		return UserName_server;
	}
	public int getScore() {
		return Score;
	}
	
	public boolean Insert_Username(String username,String password){
		boolean flag_username = false;
		if(!this.Connecting())
			return false;
		try {
			String sql = "select UserName,Password,Score FROM User;";
			PreparedStatement stmt = (PreparedStatement) connect.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				//Retrieve by column name
				String username_local = rs.getString("UserName");
			    if(username_local.equals(MD5(username))){
			    	flag_username=true;
			    	JOptionPane.showMessageDialog(null,"That username is not available.");
			    	break;
			    }
			}	
			if(!flag_username){
				String insert = "INSERT INTO User (UserName,Password,Score) VALUES(" + '"' + MD5(username) + '"' +","+ '"' + MD5(password) + '"' + ",100);";
				stmt.execute(insert);
			}
			rs.close();
			stmt.close();
			this.connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag_username)
			return false;
		return true;
	}
	
	public boolean UpDate_Score(String username, int score){
		if(!this.Connecting())
			return false;
		String sql = "select UserName,Password,Score FROM User;";
		try{
			PreparedStatement stmt = (PreparedStatement) connect.prepareStatement(sql);
			String update = "UPDATE User SET Score=" + Integer.toString(score) + " WHERE UserName=" + '"' + MD5(username) + '"' + ";";
			stmt.execute(update);
			stmt.close();
			this.connect.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	}
	
	private String MD5 (String str){
		String hashtext = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(str.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            hashtext = number.toString(16);
			//System.out.print(hashtext + "\n");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hashtext;
	}
}