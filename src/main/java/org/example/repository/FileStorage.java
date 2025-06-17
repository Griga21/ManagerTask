package org.example.repository;

import org.example.entity.Task;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FileStorage implements Storage<Long, Task> {
    private final Map<Long, String> fileStirageMap = new LinkedHashMap<>();

    @Override
    public void save(Long id, Task task) {
        String path = "D:\\WorkDir\\ManagerTask\\src\\main\\java\\org\\example\\repository\\" + id + " " + task.getTitle() + ".ser";
        try (FileOutputStream fileOutputStream = new FileOutputStream(path);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(task);
        } catch (IOException e) {
            System.out.println("Ошибка сохранения файла " + e);
        }
        fileStirageMap.put(id, path);
    }

    @Override
    public void deleteById(Long id) {
        fileStirageMap.remove(id);
    }

    @Override
    public Task getById(Long id) {
        try (FileInputStream fileInputStream = new FileInputStream(fileStirageMap.get(id));
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (Task) objectInputStream.readObject();
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
            try (FileInputStream fileInputStream = new FileInputStream(fileStirageMap.get(id));
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
