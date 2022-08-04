package com.aybaroud.mockitoExamples.annotationsExample.argumentCaptor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * ArgumentCaptor allows us to capture an argument passed to a method in order to inspect it.
 * his is especially useful when we can't access the argument outside of the method we'd like to test.
 */
@ExtendWith(MockitoExtension.class)
public class ArgumentCaptor {

    @Captor
    private org.mockito.ArgumentCaptor argumentCaptor;

    @Mock
    private List<String> mockedList;

    @Test
    void whenNotUseCaptorAnnotation_thenCorrect() {
        List mockList = Mockito.mock(List.class);
        org.mockito.ArgumentCaptor<String> arg = org.mockito.ArgumentCaptor.forClass(String.class);
        mockList.add("one");
        Mockito.verify(mockList).add(arg.capture());
        /* begin test */
        assertEquals("one", arg.getValue());
    }

    @Test
    void whenUseCaptorAnnotation_thenTheSam() {
        mockedList.add("one");
        Mockito.verify(mockedList)
                .add((String) argumentCaptor.capture());
        /* begin test */
        assertEquals("one", argumentCaptor.getValue());
    }

}
