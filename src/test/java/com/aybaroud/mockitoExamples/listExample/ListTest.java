package com.aybaroud.mockitoExamples.listExample;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

class ListTest {

    @Test
    void letsMockListSizeMethod() {
        /* Mock List class */
        List mockList = Mockito.mock(List.class);
        /* given */
        int given = 2;
        /* when then */
        Mockito.when(mockList.size())
                .thenReturn(given);
        /* begin test */
        int expected = 2;
        int actual = mockList.size();
        assertEquals(expected, actual);
    }

    @Test
    void letsMockListSizeMethod_ReturnMultipleValue() {
        /* Mock List class */
        List mockList = Mockito.mock(List.class);
        /* given */
        List<Integer> givenList = Arrays.asList(2, 3, 4);
        /* when then */
        Mockito.when(mockList.size())
                .thenReturn(givenList.get(0))
                .thenReturn(givenList.get(1))
                .thenReturn(givenList.get(2));
        /* begin test */
        assertEquals(2, mockList.size());
        assertEquals(3, mockList.size());
        assertEquals(4, mockList.size());
    }

    @Test
    void letsMockListGet() {
        /* Mock List class */
        List mockList = Mockito.mock(List.class);
        /* given */
        String given ="Aymen";
        /* when then */
        Mockito.when(mockList.get(0))
                .thenReturn(given);
        /* begin test */
        String expected = "Aymen";
        String actual = (String) mockList.get(0);
        assertEquals(expected, actual);
        assertNull(mockList.get(1));
    }

    @Test
    void letsMockListGet_UsingArgumentMatcher() {
        /* Mock List class */
        List mockList = Mockito.mock(List.class);
        /* given */
        String given ="Aymen";
        /* when then */
        Mockito.when(mockList.get(anyInt()))
                .thenReturn(given);
        /* begin test */
        String expected = "Aymen";
        assertEquals(expected, mockList.get(23));
        assertEquals(expected, mockList.get(59));
    }

    @Test
    void letsMockListGet_throwAnException() {
        /* Mock List class */
        List mockList = Mockito.mock(List.class);
        /* when then */
        Mockito.when(mockList.get(anyInt()))
                .thenThrow(new RuntimeException("Something"));
        /* begin test */
        Class<RuntimeException> expected = RuntimeException.class;
        assertThrows(expected, () -> mockList.get(0));
    }
}
