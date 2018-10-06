package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import entity.Task;
import uteis.Sessao;

public class TaskDAO extends BaseDAO {

	public Task addTask(String tarefa, Date date, String category){
		Task task = null;
		try(
				Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement("select categoryName from category where categoryName=?")
		){
			//verifica se encontrou
			statement.setString(1,category);
			ResultSet resultset = statement.executeQuery();
			System.out.println("ACHOU SAPORRA");

			//se encontrou a categoria, insere a tarefa
			if(resultset.next()){
				PreparedStatement newTask = connection.prepareStatement("insert into tarefas(tarefa, prazo, idUsuario,categoryname) values(?,?,?,?)");
				newTask.setString(1, tarefa);
				newTask.setDate(2, date);
				newTask.setLong(3, Sessao.getInstance().getCurrentUser().getId());
				newTask.setString(4, category);
				newTask.execute();
				System.out.println("ACHOU A CATEGORIA E BOTOU TAREFA");

			}else{
				//se não encontrou, insere nova categoria
				PreparedStatement newCategory = connection.prepareStatement("insert into category(categoryName, idUsuario) values (?,?)");
				newCategory.setString(1, category);
				newCategory.setLong(2, Sessao.getInstance().getCurrentUser().getId());
				newCategory.execute();
				System.out.println("NAO ACHOU A CATEGORIA E BOTOU TAREFA");

				//insere task na categoria criada
				PreparedStatement newTask = connection.prepareStatement("insert into tarefas(tarefa, prazo, idUsuario,categoryname) values(?,?,?,?)");
				newTask.setString(1, tarefa);
				newTask.setDate(2, date);
				newTask.setLong(3, Sessao.getInstance().getCurrentUser().getId());
				newTask.setString(4, category);
				newTask.execute();
			}

		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return task;

		}
	}
