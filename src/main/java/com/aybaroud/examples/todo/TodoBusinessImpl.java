package com.aybaroud.examples.todo;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class TodoBusinessImpl {

    public TodoService todoService;

    public List<String> getToDoListRelatedToSpring(String user){
        List<String> toDoListRelatedToSpring = new ArrayList<String>();
        List<String> toDoListFromUser = todoService.getToDoListFromUser(user);
        toDoListRelatedToSpring = toDoListFromUser.stream()
                .filter(action->action.contains("spring"))
                .collect(Collectors.toList());
        return toDoListRelatedToSpring;
    }
}
