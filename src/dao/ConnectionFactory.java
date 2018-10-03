package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {


	private final static String nameBD = "leviathandb";
    private final static String usuarioBD = "root";
    private final static String senhaBD = "root";

    static Connection getConnection(){
        try {
            return DriverManager
                    .getConnection(String.format("jdbc:mysql://localhost/%s?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false",nameBD),usuarioBD,senhaBD);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
