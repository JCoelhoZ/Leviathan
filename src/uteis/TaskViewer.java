package uteis;


import javafx.beans.property.SimpleStringProperty;

public class TaskViewer {
	private long id;
    private SimpleStringProperty nometarefa;

    public TaskViewer(long l, String Name) {
        this.nometarefa = new SimpleStringProperty(Name);
        this.id = l;
    }

	public String getNometarefa() {
        return nometarefa.get();
    }

	public long getIdtarefa() {
        return id;
    }
}
