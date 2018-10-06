package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Task;

public class HomeDAO extends BaseDAO {

	public List<Task> buscaTarefa(String category) throws Exception{
		List<Task> listatask = new ArrayList<Task>();
		try(
				Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement("select * from tarefas where categoryname = ?")
			){
			statement.setString(1, category);
			ResultSet resultset = statement.executeQuery();

			while(resultset.next()){
				Task task = new Task();
				task.setIdtarefa(resultset.getLong(1));
				task.setTarefa(resultset.getString(2));
				task.setDate(resultset.getDate(3));
				task.setIdUsuario(resultset.getLong(4));
				task.setCategory(resultset.getString(5));
				listatask.add(task);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(listatask);
		return listatask;
	}
}
