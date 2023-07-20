package com.Guddu.ToDoApplication.Entity;

public class Todo {
    private Integer todoId;
    private String name;
    private boolean isToDoneStatus;

    public Integer getTodoId() {
        return todoId;
    }

    public void setTodoId(Integer todoId) {
        this.todoId = todoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isToDoneStatus() {
        return isToDoneStatus;
    }

    public void setToDoneStatus(boolean toDoneStatus) {
        isToDoneStatus = toDoneStatus;
    }
}
