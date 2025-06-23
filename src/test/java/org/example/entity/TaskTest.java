package org.example.entity;

import org.example.priority.Priority;
import org.example.priority.Status;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class TaskTest {

    @Test
    public void createTAsk(){
        Task task = new Task();
        task.setTitle("Fist Task");
        task.setDescription("Testing first task");
        task.setDuration(Duration.between(LocalTime.NOON,LocalTime.MIDNIGHT));
        task.setStatus(Status.PROGRESS);
        task.setPriority(Priority.LOW);
        task.setStart(LocalTime.now());
        assertEquals( "Task [" +
                "id=" + task.getId() +
                ", title='" + "Fist Task" + '\'' +
                ", description='" + "Testing first task" + '\'' +
                ", priority=" + Priority.LOW +
                ", status=" + Status.PROGRESS +
                ", start=" + LocalTime.now() +
                ", duration=" + Duration.between(LocalTime.NOON,LocalTime.MIDNIGHT) +
                ']',task.toString());
    }
}
