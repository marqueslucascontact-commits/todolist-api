package br.com.lucas.todolistapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import br.com.lucas.todolistapi.model.Task;
import br.com.lucas.todolistapi.repository.TaskRepository;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    // Criar nova tarefa
    @PostMapping
    public Task create(@RequestBody Task task) {
        return repository.save(task);
    }

    // Listar todas as tarefas
    @GetMapping
    public List<Task> listAll() {
        return repository.findAll();
    }

    // Buscar tarefa por ID
    @GetMapping("/{id}")
    public ResponseEntity<Task> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar tarefa existente
    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task updated) {
        return repository.findById(id)
                .map(task -> {
                    task.setNome(updated.getNome());
                    task.setDataEntrega(updated.getDataEntrega());
                    task.setResponsavel(updated.getResponsavel());
                    task.setStatus(updated.getStatus());
                    repository.save(task);
                    return ResponseEntity.ok(task);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar tarefa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build();  // 404 Not Found
        }
    }
}
