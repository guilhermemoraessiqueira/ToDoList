package todo.list.moraes.toDoList.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import todo.list.moraes.toDoList.dtos.IncluirTarefasDto;
import todo.list.moraes.toDoList.dtos.TarefasDto;
import todo.list.moraes.toDoList.models.Tarefas;
import todo.list.moraes.toDoList.services.TarefasService;

import java.util.List;

@RestController
@RequestMapping("tarefas")
public class TarefasController {

    @Autowired
    private TarefasService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar (@RequestBody @Valid IncluirTarefasDto dto){
        try {
            service.incluir(dto);
            return ResponseEntity.ok().build();
        } catch (ValidationException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/pendentes")
    public ResponseEntity<List<TarefasDto>> listarPendentes(){
        List<TarefasDto> tarefas = service.listarTarefaPendentes();
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/fazendo")
    public ResponseEntity<List<TarefasDto>> listarFazendo(){
        List<TarefasDto> tarefas = service.listarTarefaFazendo();
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/concluido")
    public ResponseEntity<List<TarefasDto>> listarConcluido(){
        List<TarefasDto> tarefas = service.listarTarefaConcluido();
        return ResponseEntity.ok(tarefas);
    }
}