package uteis;

import entity.User;

public class Sessao {
	private User currentUser;
	private final static Sessao sessao = new Sessao();
	private Sessao(){
	}

	public static Sessao getInstance(){
		return sessao;
	}

	//verifica se há um usuario online
	public boolean isUsuarioLogado(){
		return currentUser != null;
	}

	//define um novo usuario a estar logado
	public void setCurrentUser(User user){
		currentUser = user;
	}
	//realiza logout
	public void removeCurrentUser(){
		currentUser = null;
	}

	public User getCurrentUser(){
		return currentUser;
	}

}
