package com.aybaroud.examples.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.List;

public class MockitoExamples {

    @Test
    void letsMockListSizeMethod(){
        List mockList = Mockito.mock(List.class);
        Mockito.when(mockList.size())
                .thenReturn(2);
        assertEquals(2,mockList.size());
    }

    @Test
    void letsMockListSizeMethod_ReturnMultipleValue(){
        var mockList = Mockito.mock(List.class);
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

}
