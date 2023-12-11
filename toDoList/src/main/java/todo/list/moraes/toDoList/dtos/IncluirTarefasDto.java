package todo.list.moraes.toDoList.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import todo.list.moraes.toDoList.authentication.user.UserModel;
import todo.list.moraes.toDoList.enums.StatusTarefasEnum;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncluirTarefasDto {
        @NotBlank
        private String titulo;
        @NotBlank
        private String descricao;
        private StatusTarefasEnum statusTarefas;
        private Date dataDeCriacao;
        private UserModel user;
}