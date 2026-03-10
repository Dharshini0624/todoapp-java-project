package com.todo.todoapp.service; // service layer package- it contains business logic

import com.todo.todoapp.model.Task;//imports task entity
import com.todo.todoapp.repository.TaskRepository;//imports repository to access database
import org.springframework.stereotype.Service;

import java.util.List;//used to return list of tasks

@Service// marks this class as a service component
public class TaskService { //this class contains business logic

    private final TaskRepository taskRepository;// repository object to talk to database

    public TaskService(TaskRepository taskRepository) { //constructor injection of repository

        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() { //Get all tasks from database
        return taskRepository.findAll();
    }

    public Task saveTask(Task task) { //save a new task into database
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) { //finds task by id or throws error if not found
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        //update task details
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setCompleted(updatedTask.isCompleted());

        //saves updated task
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        //delete task by id
        taskRepository.deleteById(id);
    }
}



