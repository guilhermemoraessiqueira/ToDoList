package todo.list.moraes.toDoList.exceptions;

public class TarefaNotFoundException extends RuntimeException {

    public TarefaNotFoundException(String mensagem) {
        super(mensagem);
    }
}