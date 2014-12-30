package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class sql_con {
	private String Server_url ="jdbc:mysql://localhost:3306/BlackJack";
	private String Server_user="root";
	private String Server_pass="123456";
	private Connection connect = null;
	private String UserName_server = null;
	private String Password_server = null;
	public sql_con(){
		System.out.print("Start Con");
	}
	private boolean Connecting(){
		System.out.print("Start Con");
		try {
			this.connect = (Connection) DriverManager.getConnection(Server_url,Server_user,Server_pass);
		} catch (SQLException e) {
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
			PreparedStatement stmt = (PreparedStatement) connect.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
			         rs.getInt("Score");
			         String username_local = rs.getString("UserName");
			         String password_local = rs.getString("Password");
			         if(username_local.equals(username)&&password_local.equals(password)){
			        	 flag_login=true;
			        	 this.UserName_server = new String(username_local);
			        	 this.Password_server = new String(password_local);
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
}