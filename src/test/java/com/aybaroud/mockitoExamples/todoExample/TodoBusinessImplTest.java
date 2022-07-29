package com.aybaroud.mockitoExamples.todoExample;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * What is Mockito ?
 *
 */
class TodoBusinessImplTest {



     @Test
     void retrieveTodoListRelatedToSpring_withList() {
          /* Mock TodoService */
          TodoService todoService = Mockito.mock(TodoService.class);

          /* given */
          List<String> todoList = Arrays.asList("Learn spring", "Learn java");
          /* when then */
          Mockito.when(todoService.getToDoListFromUser("username"))   // when
                  .thenReturn(todoList);                              // return

          /* begin test */
          TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
          int expected = 1;
          int actual = todoBusinessImpl.retrieveTodoListRelatedToSpring("username").size();  // Learn spring
          assertEquals(expected,actual);
     }

     @Test
     void retrieveTodoListRelatedToSpring_withEmptyList() {
          /* Mock TodoService */
          TodoService todoService = Mockito.mock(TodoService.class);

          /* given */
          List<String> todoList = List.of();
          /* when then */
          Mockito.when(todoService.getToDoListFromUser("username"))
                    .thenReturn(todoList);

          /* begin test */
          TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
          List<String> toDoListRelatedToSpring = todoBusinessImpl.retrieveTodoListRelatedToSpring("username");
          int expected = 0;
          int actual = toDoListRelatedToSpring.size();
          assertEquals(expected,actual);
     }

}