package todo.list.moraes.toDoList.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import todo.list.moraes.toDoList.enums.StatusTarefasEnum;

import java.util.Date;

public record IncluirTarefasDto(
        @NotBlank
        String titulo,
        @NotBlank
        String descricao,
        StatusTarefasEnum statusTarefas,
        Date dateDeCriacao) {
}