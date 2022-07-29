package com.aybaroud.mockitoExamples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class MockitoExamplesTest {

    @Mock
    private List<String> mockedList;

    @Spy
    private List<String> spiedList = new ArrayList<>();

    @Captor
    private ArgumentCaptor argCaptor;

    @Test
     void whenNotUseMockAnnotation_thenCorrect() {
        List mockList = Mockito.mock(ArrayList.class);
        mockList.add("one");
        Mockito.verify(mockList).add("one");
        /* begin test */
        assertEquals(0, mockList.size());
        /* when then */
        Mockito.when(mockList.size()).thenReturn(100);
        assertEquals(100, mockList.size());
    }

    @Test
     void whenUseMockAnnotation_thenMockIsInjected() {
        mockedList.add("one");
        Mockito.verify(mockedList).add("one");
        /* begin test */
        assertEquals(0, mockedList.size());
        /* when then */
        Mockito.when(mockedList.size()).thenReturn(100);
        assertEquals(100, mockedList.size());
     }


    @Test
     void whenNotUseSpyAnnotation_thenCorrect() {
        List<String> spyList = Mockito.spy(new ArrayList<String>());
        spyList.add("one");
        spyList.add("two");
        Mockito.verify(spyList).add("one");
        Mockito.verify(spyList).add("two");
        /* begin test */
        assertEquals(2, spyList.size());
        Mockito.doReturn(100).when(spyList).size();
        assertEquals(100, spyList.size());
    }

    @Test
    void whenUseSpyAnnotation_thenSpyIsInjectedCorrectly() {
        spiedList.add("one");
        spiedList.add("two");
        Mockito.verify(spiedList).add("one");
        Mockito.verify(spiedList).add("two");
        /* begin test */
        assertEquals(2, spiedList.size());
        Mockito.doReturn(100).when(spiedList).size();
        assertEquals(100, spiedList.size());
    }

    @Test
    void whenNotUseCaptorAnnotation_thenCorrect() {
        List mockList = Mockito.mock(List.class);
        ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);
        mockList.add("one");
        Mockito.verify(mockList).add(arg.capture());
        /* begin test */
        assertEquals("one", arg.getValue());
    }

    @Test
    void whenUseCaptorAnnotation_thenTheSam() {
        mockedList.add("one");
        Mockito.verify(mockedList).add((String) argCaptor.capture());
        /* begin test */
        assertEquals("one", argCaptor.getValue());
    }

}
