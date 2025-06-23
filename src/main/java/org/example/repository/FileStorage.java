package org.example.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.entity.Task;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FileStorage implements Storage<Long, Task> {
    private final Map<Long, Task> fileStirageMap = new LinkedHashMap<>();
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void save(Long id, Task task) {
        fileStirageMap.put(id, task);
        try {
            ObjectNode jsonNode = objectMapper.createObjectNode();
            for (Long i : fileStirageMap.keySet())
                jsonNode.put("id:Task", i + ":" + fileStirageMap.get(i).toString());
            objectMapper.writeValue(new File("src/main/resources/employeeWithUnknownProperties.json"), jsonNode);
        } catch (IOException e) {
            System.out.println("Ошибка сохранения файла " + e);
        }
    }

    @Override
    public void deleteById(Long id) {
        fileStirageMap.remove(id);
    }

    @Override
    public Task getById(Long id) {
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/employeeWithUnknownProperties.json");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Task task = (Task) objectInputStream.readObject();
        } catch (IOException e) {
            System.out.println("Ошибка сохранения файла " + e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Task> getAll() {
        List<Task> list = new LinkedList<>();
        for (Long id : fileStirageMap.keySet()) {
            try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/employeeWithUnknownProperties.json");
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                list.add((Task) objectInputStream.readObject());
            } catch (IOException e) {
                System.out.println("Ошибка сохранения файла " + e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }
}
