package DBKetNoi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	Connection connect;
	Statement stmt;
	public Connection getConnect() {
		return connect;
	}
	public void setConnect(Connection connect) {
		this.connect = connect;
	}
	public Statement getStmt() {
		return stmt;
	}
	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}
	public DBConnect(Connection connect, Statement stmt) {
		super();
		this.connect = connect;
		this.stmt = stmt;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url =  "jdbc:sqlserver://DESKTOP-T6V17Q5\\TVTHANH\\SQLEXPRESSl:1433;databaseName=DoAn2";
			String name = "sa";
			String password="1234";
			try {
				connect = DriverManager.getConnection(url, name, password);
				stmt = connect.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public DBConnect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url =  "jdbc:sqlserver://DESKTOP-T6V17Q5\\TVTHANH\\SQLEXPRESSl:1433;databaseName=DoAn2";
			String name = "sa";
			String password="1234";
			try {
				Connection connect = DriverManager.getConnection(url, name, password);
				this.stmt = connect.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	public static void main(String[] arg){
//		new DBConnect();
//		System.out.print("Thanh");
//	}
}
