package com.aybaroud.mockitoExamples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MockitoExamplesTest {

    @Mock
    List<String> mockedList;

    @Spy
    List<String> spiedList = new ArrayList<String>();

    @Captor
    ArgumentCaptor argCaptor;

    @Test
    public void whenNotUseMockAnnotation_thenCorrect() {
        List mockList = Mockito.mock(ArrayList.class);
        mockList.add("one");
        Mockito.verify(mockList).add("one");
        assertEquals(0, mockList.size());
        Mockito.when(mockList.size()).thenReturn(100);
        assertEquals(100, mockList.size());
    }

    @Test
    public void whenUseMockAnnotation_thenMockIsInjected() {
        mockedList.add("one");
        Mockito.verify(mockedList).add("one");
        assertEquals(0, mockedList.size());
        Mockito.when(mockedList.size()).thenReturn(100);
        assertEquals(100, mockedList.size());
    }

    /*
    @Test
    public void whenNotUseSpyAnnotation_thenCorrect() {
        List<String> spyList = Mockito.spy(new ArrayList<String>());
        spyList.add("one");
        spyList.add("two");
        Mockito.verify(spyList).add("one");
        Mockito.verify(spyList).add("two");
        assertEquals(2, spyList.size());
        Mockito.doReturn(100).when(spyList).size();
        assertEquals(100, spyList.size());
    }

    @Test
    public void whenUseSpyAnnotation_thenSpyIsInjectedCorrectly() {
        spiedList.add("one");
        spiedList.add("two");
        Mockito.verify(spiedList).add("one");
        Mockito.verify(spiedList).add("two");
        assertEquals(2, spiedList.size());
        Mockito.doReturn(100).when(spiedList).size();
        assertEquals(100, spiedList.size());
    }*/

    @Test
    public void whenNotUseCaptorAnnotation_thenCorrect() {
        List mockList = Mockito.mock(List.class);
        ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);
        mockList.add("one");
        Mockito.verify(mockList).add(arg.capture());
        assertEquals("one", arg.getValue());
    }

    @Test
    public void whenUseCaptorAnnotation_thenTheSam() {
        mockedList.add("one");
        Mockito.verify(mockedList).add((String) argCaptor.capture());
        assertEquals("one", argCaptor.getValue());
    }

    @Test
    void letsMockListSizeMethod(){
        List mockList = Mockito.mock(List.class);
        Mockito.when(mockList.size()).thenReturn(2);
        assertEquals(2,mockList.size());
    }

    @Test
    void letsMockListSizeMethod_ReturnMultipleValue(){
        List mockList = Mockito.mock(List.class);
        Mockito.when(mockList.size())
                .thenReturn(2)
                .thenReturn(3)
                .thenReturn(4);
        assertEquals(2,mockList.size());
        assertEquals(3,mockList.size());
        assertEquals(4,mockList.size());
    }

    @Test
    void letsMockListGet(){
        List mockList = Mockito.mock(List.class);
        Mockito.when(mockList.get(0))
                .thenReturn("Aymen");
        assertEquals("Aymen",mockList.get(0));
        assertEquals(null,mockList.get(1));
    }

    @Test
    void letsMockListGet_UsingArgumentMatcher(){
        List mockList = Mockito.mock(List.class);
        // anyMethod() is an argument matcher
        Mockito.when(mockList.get(anyInt()))
                .thenReturn("Aymen");
        assertEquals("Aymen",mockList.get(0));
        assertEquals("Aymen",mockList.get(1));
    }

    @Test
    void letsMockListGet_throwAnException(){
        List mockList = Mockito.mock(List.class);
        // anyMethod() is an argument matcher
        Mockito.when(mockList.get(anyInt()))
                .thenThrow(new RuntimeException("Something"));
        assertThrows(RuntimeException.class, ()->mockList.get(0));
    }

    /////////////////////////////////////////////////////////////////////////////////////
    ///               getToDoListFromUserget           ToDoListRelatedToSpring        ///
    /////////////////////////////////////////////////////////////////////////////////////
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
