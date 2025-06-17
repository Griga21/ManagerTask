package org.example.entity;

public class SubTask extends Task {
    private long epicTaskId;

    public SubTask(long epicTaskId) {
        this.epicTaskId = epicTaskId;
    }

    public long getEpicTaskId() {
        return epicTaskId;
    }
}
