package entity;

import java.sql.Date;

public class Task {
	private long idtarefa;
	private String tarefa;
	private String category;
	private Date date;

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getIdtarefa() {
		return idtarefa;
	}
	public void setIdtarefa(long idtarefa) {
		this.idtarefa = idtarefa;
	}
	public String getTarefa() {
		return tarefa;
	}
	public void setTarefa(String tarefa) {
		this.tarefa = tarefa;
	}
}
