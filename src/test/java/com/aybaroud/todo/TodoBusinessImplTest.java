package com.aybaroud.todo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodoBusinessImplTest {

    @Test
    void getToDoListRelatedToSpring_withMock() {
        TodoService todoService = Mockito.mock(TodoService.class);
        List todoList = Arrays.asList("Learn spring", "Learn java", "Learn spring boot");
        Mockito.when(todoService.getToDoListFromUser("Aymen"))
                .thenReturn(todoList);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        List<String> toDoListRelatedToSpring = todoBusinessImpl.getToDoListRelatedToSpring("Aymen");
        assertEquals(2,toDoListRelatedToSpring.size());
    }

    @Test
    void getToDoListRelatedToSpring_withEmptyList() {
        TodoService todoService = Mockito.mock(TodoService.class);
        List todoList = Arrays.asList();
        Mockito.when(todoService.getToDoListFromUser("Aymen"))
                .thenReturn(todoList);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        List<String> toDoListRelatedToSpring = todoBusinessImpl.getToDoListRelatedToSpring("Aymen");
        assertEquals(0,toDoListRelatedToSpring.size());
    }
}