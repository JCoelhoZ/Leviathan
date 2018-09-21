package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public final static String stringConexao = "jdbc:mysql://localhost:3306/leviathandb?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
	public final static String nameDB = "leviathandb";
	public final static String usuarioBD = "root";
	public final static String senhaBD = "root";

	static Connection getConnection(){
	try {
		return DriverManager.getConnection(String.format(stringConexao,
				nameDB,
				usuarioBD,
				senhaBD));
	}
		catch(SQLException e){
	}
		throw new RuntimeException();
	}

}
