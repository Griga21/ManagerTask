package org.example.repository;

import org.example.entity.Task;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class InMemoryStorage implements Storage<Long, Task> {
    private Map<Long, Task> taskMap = new LinkedHashMap<>();

    @Override
    public void save(Long id, Task task) {
        taskMap.put(id, task);
    }

    @Override
    public void deleteById(Long id) {
        taskMap.remove(id);
    }

    @Override
    public Task getById(Long id) {
        return taskMap.get(id);
    }

    @Override
    public List<Task> getAll() {
        List<Task> list = new LinkedList<>();
        for (Long id : taskMap.keySet()) {
            list.add(taskMap.get(id));
        }
        return list;
    }

}
