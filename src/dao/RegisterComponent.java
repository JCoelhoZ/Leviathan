package dao;

import entity.User;
import uteis.Strings;

public class RegisterComponent {

	private RegisterDAO dao;
	public RegisterComponent(){
		dao = new RegisterDAO();
	}

	//verifica se os campos solicitados foram preenchidos
	public User realizarRegistro(String email, String password, String passwordConfirm) throws Exception{
		if(Strings.isNullOrEmpty(email) || Strings.isNullOrEmpty(password) || Strings.isNullOrEmpty(passwordConfirm)){
			throw new Exception("Preencha todos os campos");
		}else{
		User user = dao.cadastrarUsuario(email, password, passwordConfirm);
		return user;
		}
	}


}
