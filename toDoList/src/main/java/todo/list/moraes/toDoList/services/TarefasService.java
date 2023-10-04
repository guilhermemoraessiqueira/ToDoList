package todo.list.moraes.toDoList.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import todo.list.moraes.toDoList.dtos.IncluirTarefasDto;
import todo.list.moraes.toDoList.dtos.TarefasDto;
import todo.list.moraes.toDoList.enums.StatusTarefasEnum;
import todo.list.moraes.toDoList.models.Tarefas;
import todo.list.moraes.toDoList.repository.TarefasRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarefasService {

    @Autowired
    TarefasRepository repository;

    public void incluir(IncluirTarefasDto dto){
        repository.save(new Tarefas(dto));
    }

    public List<TarefasDto> listarTarefaPendentes() {
        List<Tarefas> tarefasPendentes = repository.findByStatus(StatusTarefasEnum.PENDENTE);

        List<TarefasDto> tarefasDTOS = new ArrayList<>();

        for (Tarefas tarefa : tarefasPendentes) {
            tarefasDTOS.add(new TarefasDto(
                    tarefa.getTitulo(),
                    tarefa.getDescricao(),
                    tarefa.getStatus(),
                    tarefa.getDataDeCriacao()
            ));
        }

        return tarefasDTOS;
    }

    public List<TarefasDto> listarTarefaFazendo() {
        List<Tarefas> tarefasPendentes = repository.findByStatus(StatusTarefasEnum.FAZENDO);

        List<TarefasDto> tarefasDTOS = new ArrayList<>();

        for (Tarefas tarefa : tarefasPendentes) {
            tarefasDTOS.add(new TarefasDto(
                    tarefa.getTitulo(),
                    tarefa.getDescricao(),
                    tarefa.getStatus(),
                    tarefa.getDataDeCriacao()
            ));
        }

        return tarefasDTOS;
    }

    public List<TarefasDto> listarTarefaConcluido() {
        List<Tarefas> tarefasPendentes = repository.findByStatus(StatusTarefasEnum.CONCLUÍDO);

        List<TarefasDto> tarefasDTOS = new ArrayList<>();

        for (Tarefas tarefa : tarefasPendentes) {
            tarefasDTOS.add(new TarefasDto(
                    tarefa.getTitulo(),
                    tarefa.getDescricao(),
                    tarefa.getStatus(),
                    tarefa.getDataDeCriacao()
            ));
        }

        return tarefasDTOS;
    }
}