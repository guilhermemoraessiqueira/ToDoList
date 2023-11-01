package todo.list.moraes.toDoList.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todo.list.moraes.toDoList.dtos.AlterarStatusDto;
import todo.list.moraes.toDoList.dtos.IncluirTarefasDto;
import todo.list.moraes.toDoList.dtos.TarefasDto;
import todo.list.moraes.toDoList.enums.StatusTarefasEnum;
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

    @GetMapping("/status/{status}")
    public ResponseEntity<List<TarefasDto>> listarPorStatus(@PathVariable StatusTarefasEnum status){
        List<TarefasDto> tarefas = service.listarTarefaPorStatus(status);
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/{tarefaId}")
    public ResponseEntity<Tarefas> obterTarefaPorId(@PathVariable Long tarefaId) {
        Tarefas tarefas = service.buscarTarefaPorId(tarefaId);

        if (tarefas != null) {
            return ResponseEntity.ok(tarefas);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/atualizar-status")
    public ResponseEntity<String> atualizarStatusTarefa(
            @PathVariable Long id,
            @RequestBody AlterarStatusDto alterarStatusDto) {

        StatusTarefasEnum novoStatus = alterarStatusDto.status();

        if (novoStatus == null) {
            return ResponseEntity.badRequest().body("O status da tarefa não pode ser nulo");
        }

        try {
            service.atualizarStatusTarefa(id, novoStatus);
            return ResponseEntity.ok("Status da tarefa atualizado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}