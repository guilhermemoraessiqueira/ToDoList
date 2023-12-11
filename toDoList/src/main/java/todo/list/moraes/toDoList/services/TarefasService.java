package todo.list.moraes.toDoList.services;

import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import todo.list.moraes.toDoList.authentication.user.UserModel;
import todo.list.moraes.toDoList.dtos.IncluirTarefasDto;
import todo.list.moraes.toDoList.dtos.TarefasDto;
import todo.list.moraes.toDoList.enums.StatusTarefasEnum;
import todo.list.moraes.toDoList.exceptions.TarefaNotFoundException;
import todo.list.moraes.toDoList.models.Tarefas;
import todo.list.moraes.toDoList.repository.TarefasRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarefasService {

    @Autowired
    TarefasRepository repository;

    public void incluir(IncluirTarefasDto dto, @AuthenticationPrincipal UserModel userPrincipal){
        UserModel currentUser = userPrincipal;
        dto.setUser(currentUser);
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

    public TarefasDto buscarTarefaPorId(Long tarefaId) {
        Tarefas tarefa = repository.findById(tarefaId).orElse(null);

        if (tarefa != null) {
            TarefasDto tarefasDto = tarefa.toDto();
            return tarefasDto;
        } else {
            // Se a tarefa não foi encontrada, você pode decidir como lidar com isso.
            // Aqui, estamos retornando null, mas você pode lançar uma exceção ou tomar outra ação apropriada.
            return null;
        }
    }

    public void atualizarTituloEDescricao(Long idTarefa, String tituloNovo, String descricaoNova) {
        Tarefas tarefas = repository.findById(idTarefa)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        tarefas.setTitulo(tituloNovo);
        tarefas.setDescricao(descricaoNova);
        repository.save(tarefas);
    }

    public void deletarTarefa(Long tarefaId) {
        // Verifica se a tarefa existe antes de tentar deletar
        if (repository.existsById(tarefaId)) {
            repository.deleteById(tarefaId);
        } else {
            throw new TarefaNotFoundException("Tarefa não encontrada com o ID: " + tarefaId);
        }
    }
}