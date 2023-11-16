package todo.list.moraes.toDoList.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import todo.list.moraes.toDoList.dtos.IncluirTarefasDto;
import todo.list.moraes.toDoList.enums.StatusTarefasEnum;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_tarefas")
public class Tarefas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatusTarefasEnum status;

    private String titulo;

    private String descricao;

    private LocalDateTime  dataDeCriacao;

    //private Long idUsuario; mais pra frente

    public Tarefas(IncluirTarefasDto dto) {
        this.status = StatusTarefasEnum.PENDENTE;
        this.titulo = dto.titulo();
        this.descricao = dto.descricao();
        this.dataDeCriacao = LocalDateTime.now();
    }
}