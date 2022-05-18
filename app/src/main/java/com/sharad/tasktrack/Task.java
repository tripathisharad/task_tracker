package com.sharad.tasktrack;

import java.io.Serializable;

public class Task implements Serializable {

    String taskName;
    int initialValue;
    int finalValue;

    public Task(String taskName, int initialValue, int finalValue) {
        this.taskName = taskName;
        this.initialValue = initialValue;
        this.finalValue = finalValue;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(int initialValue) {
        this.initialValue = initialValue;
    }

    public int getFinalValue() {
        return finalValue;
    }

    public void setFinalValue(int finalValue) {
        this.finalValue = finalValue;
    }
}
