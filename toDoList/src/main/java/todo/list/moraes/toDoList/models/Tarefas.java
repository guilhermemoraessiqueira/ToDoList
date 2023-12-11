package todo.list.moraes.toDoList.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import todo.list.moraes.toDoList.authentication.user.UserModel;
import todo.list.moraes.toDoList.dtos.IncluirTarefasDto;
import todo.list.moraes.toDoList.dtos.TarefasDto;
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    public Tarefas(IncluirTarefasDto dto) {
        this.status = StatusTarefasEnum.PENDENTE;
        this.titulo = dto.getTitulo();
        this.descricao = dto.getDescricao();
        this.dataDeCriacao = LocalDateTime.now();
        this.user = dto.getUser();
    }

    public Tarefas(String titulo, String descricao, StatusTarefasEnum status, LocalDateTime dataDeCriacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.dataDeCriacao = dataDeCriacao;
    }

    public static Tarefas fromDto(TarefasDto tarefasDto) {
        return new Tarefas(tarefasDto.titulo(), tarefasDto.descricao(), tarefasDto.status(), tarefasDto.dataDeCriacao());
    }

    public TarefasDto toDto() {
        return new TarefasDto(this.titulo, this.descricao, this.status, this.dataDeCriacao);
    }
}