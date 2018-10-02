package dao;

import entity.User;
import uteis.Sessao;
import uteis.Strings;

public class LoginComponent {


	private LoginDAO dao;
	public LoginComponent(){
		dao = new LoginDAO();
	}

	//verifica se os campos solicitados foram preenchidos
	public User realizarLogin(String email, String password) throws Exception{
		if(Strings.isNullOrEmpty(email) || Strings.isNullOrEmpty(password)){
			throw new Exception("Informe o email e password");
		}
		User user = dao.buscarEmail(email);

		//verifica se a senha esta correta
		if(!user.getPassword().equals(password)){
			throw new Exception("Usuário ou senha incorretos");
		}

		//inicia sessão
		Sessao.getInstance().setCurrentUser(user);

		return user;
	}
}
