package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	static String bd = "covid";
	static String parametros = "?useSSL=false&serverTimezone=UTC";
	static String user = "root";
	static String password = "root";
	static String url = "jdbc:mysql://localhost:3306/" + bd + parametros;
	Connection conn=null;
	public DbConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn= DriverManager.getConnection(url,user,password);
			
			if (conn!=null) {
				System.out.println("BASE DE DATOS CONECTADA CORRECTAMENTE");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("ERROR");
		}
		
		
	}
	
	public Connection getConnection() {
		
		return this.conn;
	}
	
	public void disconnect() {
		
		try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("ERROR AL CERRAR LA BASE DE DATOS");
		}
		
		if (conn!=null) {
			System.out.println("BASE DE DATOS DESCONECTADA CON EXITO");
		}
		
		
	}

}
