package todo.list.moraes.toDoList.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.list.moraes.toDoList.dtos.IncluirTarefasDto;
import todo.list.moraes.toDoList.dtos.TarefasDto;
import todo.list.moraes.toDoList.enums.StatusTarefasEnum;
import todo.list.moraes.toDoList.models.Tarefas;
import todo.list.moraes.toDoList.repository.TarefasRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarefasService {

    @Autowired
    TarefasRepository repository;

    public void incluir(IncluirTarefasDto dto){
        repository.save(new Tarefas(dto));
    }

    public List<TarefasDto> listarTarefaPorStatus(StatusTarefasEnum status) {
        List<Tarefas> tarefasPendentes = repository.findByStatus(status);

        List<TarefasDto> tarefasDTOS = new ArrayList<>();

        for (Tarefas tarefa : tarefasPendentes) {
            tarefasDTOS.add(new TarefasDto(
                    tarefa.getTitulo(),
                    tarefa.getDescricao(),
                    tarefa.getStatus(),
                    tarefa.getDataDeCriacao()));
        }

        return tarefasDTOS;
    }

    public void atualizarStatusTarefa(Long tarefaId, StatusTarefasEnum novoStatus) {
        Tarefas tarefa = repository.findById(tarefaId)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        tarefa.setStatus(novoStatus);
        repository.save(tarefa);
    }

    public Tarefas buscarTarefaPorId(Long tarefaId) {
        return repository.findById(tarefaId).orElse(null);
    }

    public void atualizarTituloEDescricao(Long idTarefa, String tituloNovo, String descricaoNova) {
        Tarefas tarefas = repository.findById(idTarefa)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        tarefas.setTitulo(tituloNovo);
        tarefas.setDescricao(descricaoNova);
        repository.save(tarefas);
    }
}