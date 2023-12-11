package todo.list.moraes.toDoList.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import todo.list.moraes.toDoList.authentication.user.UserModel;
import todo.list.moraes.toDoList.dtos.AlterarStatusDto;
import todo.list.moraes.toDoList.dtos.AlterarTituloEDescricao;
import todo.list.moraes.toDoList.dtos.IncluirTarefasDto;
import todo.list.moraes.toDoList.dtos.TarefasDto;
import todo.list.moraes.toDoList.enums.StatusTarefasEnum;
import todo.list.moraes.toDoList.exceptions.TarefaNotFoundException;
import todo.list.moraes.toDoList.services.TarefasService;

import java.util.List;

@RestController
@RequestMapping("tarefas")
public class TarefasController {

    @Autowired
    private TarefasService service;

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity cadastrar (@RequestBody @Valid IncluirTarefasDto dto, @AuthenticationPrincipal UserModel userPrincipal){
        UserModel currentUser = userPrincipal;

        dto.setUser(currentUser);
        try {
            service.incluir(dto, userPrincipal);
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
    public ResponseEntity<TarefasDto> obterTarefaPorId(@PathVariable Long tarefaId) {
        TarefasDto tarefasDto = service.buscarTarefaPorId(tarefaId);

        if (tarefasDto != null) {
            return ResponseEntity.ok(tarefasDto);
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

    @PutMapping("/{id}/atualizar-titulo-descricao")
    public ResponseEntity<String> atualizarTituloDescricao(
            @PathVariable Long id,
            @RequestBody AlterarTituloEDescricao alterarTituloEDescricao) {

        String tituloNovo = alterarTituloEDescricao.titulo();
        String descricaoNova = alterarTituloEDescricao.descricao();

        service.atualizarTituloEDescricao(id, tituloNovo, descricaoNova);
        return ResponseEntity.ok("Tarefa atualizada com sucesso!");

    }

    @DeleteMapping("/{id}/deletar-tarefa")
    public ResponseEntity<String> deletarTarefa(@PathVariable Long id) {
        try {
            service.deletarTarefa(id);
            return ResponseEntity.ok("Tarefa deletada com sucesso!");
        } catch (TarefaNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar a tarefa");
        }
    }
}