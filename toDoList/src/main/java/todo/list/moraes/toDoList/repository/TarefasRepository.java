package todo.list.moraes.toDoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.list.moraes.toDoList.models.Tarefas;

public interface TarefasRepository extends JpaRepository<Tarefas, Long> {
}
