package todo.list.moraes.toDoList.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import todo.list.moraes.toDoList.dtos.IncluirTarefasDto;
import todo.list.moraes.toDoList.services.TarefasService;

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
}