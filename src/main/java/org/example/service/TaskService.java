package org.example.service;

import org.example.entity.Task;

import java.util.List;

public interface TaskService {
    String add(Task task);

    String deleteById(Long id);

    Task getByID(Long id);

    List<Task> getALL();
}
