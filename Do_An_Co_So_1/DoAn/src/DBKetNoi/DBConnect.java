package DBKetNoi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
Statement stmt;
Connection con;
public Statement getStmt() {
	return stmt;
}
public void setStmt(Statement stmt) {
	this.stmt = stmt;
}
public Connection getCon() {
	return con;
}
public void setCon(Connection con) {
	this.con = con;
}
	public DBConnect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			try {
				String url="jdbc:sqlserver://DESKTOP-1TUDKSE\\\\SQLEXPRESSl:1433;databaseName=QuanLyBongDa";
				String usesname = "sa";
				String password = "1234";
				Connection con = DriverManager.getConnection(url, usesname, password);
				this.stmt = con.createStatement();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new DBConnect();
	}
}
