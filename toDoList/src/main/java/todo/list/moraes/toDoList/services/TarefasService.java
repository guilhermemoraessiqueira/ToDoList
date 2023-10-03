package todo.list.moraes.toDoList.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.list.moraes.toDoList.dtos.IncluirTarefasDto;
import todo.list.moraes.toDoList.models.Tarefas;
import todo.list.moraes.toDoList.repository.TarefasRepository;

import java.time.LocalDate;
import java.util.Date;

@Service
public class TarefasService {

    @Autowired
    TarefasRepository repository;

    public void incluir(IncluirTarefasDto dto){
        repository.save(new Tarefas(dto));
    }
}