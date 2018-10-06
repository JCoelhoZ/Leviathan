package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Task;
import uteis.Sessao;

public class HomeDAO extends BaseDAO {

	public List<Task> buscaTarefa(String category) {
		ArrayList<Task> listatask = new ArrayList<Task>();
		try(
				Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement("select * from tarefas where categoryname = ? and idUsuario = ?")
			){
			statement.setString(1, category);
			statement.setLong(2, Sessao.getInstance().getCurrentUser().getId());
			ResultSet resultset = statement.executeQuery();

			while(resultset.next()){
				Task task = new Task();
				task.setIdtarefa(resultset.getLong(1));
				task.setTarefa(resultset.getString(2));
				task.setIdUsuario(resultset.getLong(3));
				task.setCategoryName(resultset.getString(4));
				listatask.add(task);
				System.out.println("foi");
				System.out.println(task.getTarefa());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(listatask);
		return listatask;
	}
}
