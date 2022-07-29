package com.aybaroud.mockitoExamples.todoExample;

import lombok.AllArgsConstructor;
import java.util.List;


@AllArgsConstructor
public class TodoBusinessImpl {

    private TodoService todoService;

    public List<String> retrieveTodoListRelatedToSpring(String user){
        List<String> toDoListRelatedToSpring;

        List<String> toDoListFromUser = todoService.getToDoListFromUser(user);
        toDoListRelatedToSpring = toDoListFromUser.stream()
                .filter(action->action.contains("Learn spring"))
                .toList();
        return toDoListRelatedToSpring;
    }
}
