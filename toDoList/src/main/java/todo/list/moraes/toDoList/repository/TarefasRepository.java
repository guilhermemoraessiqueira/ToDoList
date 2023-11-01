package todo.list.moraes.toDoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.list.moraes.toDoList.enums.StatusTarefasEnum;
import todo.list.moraes.toDoList.models.Tarefas;

import java.util.List;

public interface TarefasRepository extends JpaRepository<Tarefas, Long> {

    List<Tarefas> findByStatus(StatusTarefasEnum status);
}