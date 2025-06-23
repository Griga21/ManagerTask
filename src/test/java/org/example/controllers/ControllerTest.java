package org.example.controllers;

import org.example.controller.TaskController;
import org.example.entity.Task;
import org.example.priority.Priority;
import org.example.priority.Status;
import org.example.service.TaskServiceImpl;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class ControllerTest {
    private final TaskController taskController = new TaskController(new TaskServiceImpl());
    Task task = new Task();


    @Test
    public void addTask() {
        task.setTitle("Fist Task");
        task.setDescription("Testing first task");
        task.setDuration(Duration.between(LocalTime.NOON, LocalTime.MIDNIGHT));
        task.setStatus(Status.PROGRESS);
        task.setPriority(Priority.LOW);
        task.setStart(LocalTime.now());
        System.out.println(taskController.add(task));
        assertEquals(task, taskController.getByID(task.getId()));
    }

    @Test
    public void findById() {
        task.setTitle("Fist Task");
        task.setDescription("Testing first task");
        task.setDuration(Duration.between(LocalTime.NOON, LocalTime.MIDNIGHT));
        task.setStatus(Status.PROGRESS);
        task.setPriority(Priority.LOW);
        task.setStart(LocalTime.now());
        System.out.println(taskController.add(task));
        Task task1 = new Task();
        System.out.println(taskController.add(task1));
        assertEquals("Task [" +
                "id=" + 2 +
                ", title='" + "Fist Task" + '\'' +
                ", description='" + "Testing first task" + '\'' +
                ", priority=" + Priority.LOW +
                ", status=" + Status.PROGRESS +
                ", start=" + task.getStart() +
                ", duration=" + Duration.between(LocalTime.NOON, LocalTime.MIDNIGHT) +
                ']', taskController.getByID(2L).toString());
    }

    @Test
    public void deleteTask() {
        System.out.println(taskController.add(task));
        System.out.println(taskController.deleteById(task.getId()));
    }

}
