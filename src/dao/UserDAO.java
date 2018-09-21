package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import entity.User;

public class UserDAO {
	public void isert(User user) {
		try {
			Connection conn = (new ConnectionFactory()).getConnection();
			PreparedStatement p = conn.prepareStatement("insert into user(name,password) values (?, ?)");
			p.setString(1, user.getName());
			p.setString(2, user.getPassword());

		}catch(Exception e){
			throw new RuntimeException();

		}
	}
}
