package org.example.entity;

import java.util.List;

public class Epic extends Task{
    List<SubTask> subTaskList;

    public List<SubTask> getSubTaskList() {
        return subTaskList;
    }
}
