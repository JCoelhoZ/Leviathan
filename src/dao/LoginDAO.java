package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.User;
import uteis.Strings;

public class LoginDAO extends BaseDAO {

	//usado no LoginComponent, verifica se a senha bate com o usuario digitado
	User buscarEmail(String email) throws Exception{
		User user = null;
		if(Strings.isNullOrEmpty(email)){
			throw new Exception("Email inválido");
		}

		//busca no banco o email digitado na tela de login
		try(
				Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement("select idUsuario, nome, email, password from usuario where email=?")
		){
			statement.setString(1,email);
			ResultSet resultset = statement.executeQuery();

			//caso encontrado, trás os dados do usuário para iniciar a seção
			if(resultset.next()){
				user = new User();
				user.setId(resultset.getLong(1));
				user.setName(resultset.getString(2));
				user.setEmail(resultset.getString(3));
				user.setPassword(resultset.getString(4));
			}

		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		if(user==null){
			throw new Exception("Usuário não encontrado");
		}
		return user;

	}

}
