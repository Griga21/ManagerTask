package org.example.repository;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface Storage<Long, Task> {
    void save(Long id, Task task) throws JsonProcessingException;

    void deleteById(Long id);

    Task getById(Long id);

    List<Task> getAll();
}
