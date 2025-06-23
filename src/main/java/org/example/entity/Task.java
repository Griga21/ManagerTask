package org.example.entity;

import org.example.priority.Priority;
import org.example.priority.Status;

import java.time.Duration;
import java.time.LocalTime;

public class Task {
    private static Long countId = 0L;
    private final Long id;
    private String title;
    private String description;
    private Priority priority;
    private Status status;
    private LocalTime start;
    private Duration duration;

    public Task() {
        this.id = ++countId;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "Task [" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                ", start=" + start +
                ", duration=" + duration +
                ']';
    }
}
