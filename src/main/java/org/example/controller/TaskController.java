package org.example.controller;

import org.example.entity.Task;
import org.example.service.TaskService;

import java.util.List;

public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    public String add(Task task) {
        taskService.add(task);
        return "Задача создана с ID: " + task.getId();
    }


    public String deleteById(Long id) {
        taskService.deleteById(id);
        return "Задача удалена с ID: " + id;
    }


    public Task getByID(Long id) {
        return taskService.getByID(id);
    }

    public List<Task> getALL() {
        return taskService.getALL();
    }
}
