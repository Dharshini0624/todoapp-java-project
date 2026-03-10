package com.todo.todoapp.repository;
//Repository package - handles database operations
import com.todo.todoapp.model.Task;
//imports task entity(table)
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//marks this interface as a database repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    //Jpa Repository provides built-in CRUD operations
    //Task- entity class
    //Long- Data type of primary key(id)
}
