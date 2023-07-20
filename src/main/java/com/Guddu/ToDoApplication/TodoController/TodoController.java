package com.Guddu.ToDoApplication.TodoController;

import com.Guddu.ToDoApplication.Entity.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class TodoController {
    private List<Todo> myTodos;

    public TodoController() {
        myTodos=new ArrayList<>();
    }

    @GetMapping("all/todo")
    public List<Todo> getAllTodos(){
        return myTodos;
    }

    @GetMapping("all/done/todo")
    public List<Todo> getDoneTodos(){
        List<Todo> doneTodos = new ArrayList<>();
        for(Todo myTodo : myTodos)  {
            if(myTodo.isToDoneStatus()){
                doneTodos.add(myTodo);
            }
        }
        return doneTodos;
    }

    @GetMapping("all/undone/todo")
    public List<Todo> getNotDoneTodos(){
        List<Todo> unDoneTodos = new ArrayList<>();
        for(Todo myTodo : myTodos)  {
            if(!myTodo.isToDoneStatus()){
                unDoneTodos.add(myTodo);
            }
        }
        return unDoneTodos;
    }
    @PostMapping("todo")
    public String addTodo(@RequestBody Todo todo){
        myTodos.add(todo);
        return "todo is added";
    }

    @PutMapping("todo/update/{todoId}/{status}")

    public String markTodo(@PathVariable Integer todoId, @PathVariable boolean status){
        for(Todo myTodo : myTodos){
            if(myTodo.getTodoId().equals(todoId)){
                myTodo.setToDoneStatus(status);
                return "todo updated for todo ID "+todoId;
            }
        }
        return "todo not found for todo ID "+ todoId;
    }
    @DeleteMapping("delete/todo")

    public String removeTodo(@RequestParam Integer todoId){
        for(Todo myTodo : myTodos){
            if(myTodo.getTodoId().equals(todoId)){
                myTodos.remove(myTodo);
                return "todo removed for todoId "+todoId;
            }
        }
        return "todo not deleted as if not exist";
    }

}
