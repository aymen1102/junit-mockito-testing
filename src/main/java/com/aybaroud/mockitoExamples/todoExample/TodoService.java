package com.aybaroud.mockitoExamples.todoExample;

import java.util.List;

public interface TodoService {
    List<String> getToDoListFromUser(String user);
}
