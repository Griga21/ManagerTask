package org.example.repository;

import java.util.List;

public interface Storage<Long, Task> {
    void save(Long id, Task task);

    void deleteById(Long id);

    Task getById(Long id);

    List<Task> getAll();
}
