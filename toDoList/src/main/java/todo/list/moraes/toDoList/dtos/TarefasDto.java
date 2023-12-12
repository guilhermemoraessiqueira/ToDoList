package todo.list.moraes.toDoList.dtos;

import todo.list.moraes.toDoList.enums.StatusTarefasEnum;

import java.time.LocalDateTime;

public record TarefasDto(String titulo,
                         String descricao,
                         StatusTarefasEnum status,
                         LocalDateTime dataDeCriacao) {
}