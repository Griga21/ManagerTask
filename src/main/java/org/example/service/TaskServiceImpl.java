package org.example.service;

import org.example.entity.Task;
import org.example.repository.FileStorage;
import org.example.repository.InMemoryStorage;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    InMemoryStorage inMemoryStorage = new InMemoryStorage();
    FileStorage fileStorage = new FileStorage();

    @Override
    public String add(Task task) {
        inMemoryStorage.save(task.getId(), task);
        fileStorage.save(task.getId(), task);
        return "200";
    }

    @Override
    public String deleteById(Long id) {
        inMemoryStorage.deleteById(id);
        fileStorage.deleteById(id);
        return "200";
    }

    @Override
    public Task getByID(Long id) {
        return inMemoryStorage.getById(id);
        //return fileStorage.getById(id);
    }

    @Override
    public List<Task> getALL() {
        return inMemoryStorage.getAll();
        //return fileStorage.getAll();
    }
}
