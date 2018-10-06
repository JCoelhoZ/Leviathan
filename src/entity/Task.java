package entity;

public class Task {

	private long idtarefa;
	private String tarefa;
	private String categoryname;
	private long idUsuario;


	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getCategoryName() {
		return categoryname;
	}
	public void setCategoryName(String categoryname) {
		this.categoryname = categoryname;
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
