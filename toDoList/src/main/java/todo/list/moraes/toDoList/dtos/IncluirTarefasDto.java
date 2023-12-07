package todo.list.moraes.toDoList.dtos;

import jakarta.validation.constraints.NotBlank;
import todo.list.moraes.toDoList.enums.StatusTarefasEnum;

import java.util.Date;

public record IncluirTarefasDto(
        @NotBlank
        String titulo,
        @NotBlank
        String descricao,
        StatusTarefasEnum statusTarefas,
        Date dataDeCriacao) {
}