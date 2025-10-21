package br.com.lucas.todolistapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.lucas.todolistapi.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
