package uteis;

import java.util.ArrayList;
import java.util.List;

import entity.Task;

public class TaskAdapter {
	public static TaskViewer adpaptarParaView(Task t) {
        return new TaskViewer(t.getIdtarefa(), t.getTarefa());
    }

    public static Task adaptarViewParaTarefa(TaskViewer tv) {
        Task t = new Task();
        t.setIdtarefa(tv.getIdtarefa());
        t.setTarefa(tv.getNometarefa());
        return t;
    }

    public static List<TaskViewer> adaptarTodosParaView(List<Task> tarefasList) {
        List<TaskViewer> lista = new ArrayList<TaskViewer>();
        for (Task t : tarefasList) {
            lista.add(new TaskViewer(t.getIdtarefa(), t.getTarefa()));
        }
        return lista;
    }
}
