package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.User;
//import uteis.Strings;

public class RegisterDAO extends BaseDAO{
	User cadastrarUsuario(String email, String password, String passwordConfirm) throws Exception{
		User user = null;

		//busca no banco o email digitado na tela de login
		try(
				Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement("select idUsuario, email from usuario where email=?")
		){
			statement.setString(1,email);
			ResultSet resultset = statement.executeQuery();

			//caso encontrado, não permite o cadastro. Caso contrário, insere o usuário na tabela
			if(resultset.next()){
				throw new Exception("Email já cadastrado");
			}else{
				PreparedStatement inserir = connection.prepareStatement("insert into usuario(email, password) values (?,?)");
				inserir.executeQuery();
			}

		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return user;

	}

}
