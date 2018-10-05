package dao;

import entity.User;
import uteis.Strings;

public class RegisterComponent {

	private RegisterDAO dao;
	public RegisterComponent(){
		dao = new RegisterDAO();
	}

	//verifica se os campos solicitados foram preenchidos e se os passwords digitados batem
	public User realizarRegistro(String email, String password, String passwordConfirm) throws Exception{
		if(Strings.isNullOrEmpty(email) || Strings.isNullOrEmpty(password) || Strings.isNullOrEmpty(passwordConfirm)){
			throw new Exception("Preencha todos os campos");

		}else if(!Strings.isEqual(password, passwordConfirm)){
			throw new Exception("Os passwords digitados não são iguais");

		}else{
		User user = dao.cadastrarUsuario(email, password, passwordConfirm);
		return user;
		}
	}


}
