package com.aybaroud.mockitoExamples.annotationsExample.mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class MockTest {

    @Mock
    private List<String> mockedList;

    //////////////////////////////////////////////////////////////
    //           Mock annotation                                //
    //////////////////////////////////////////////////////////////
    @Test
    void whenNotUseMockAnnotation_thenCorrect() {
        /* Mock List class */
        List mockList = Mockito.mock(List.class);
        /* Verify mockList */
        mockList.add("one");
        Mockito.verify(mockList).add("one");  //verify is used to check if a mock method was called with required arguments or not.
                                              //if not the test is failed error:"Actually, there were zero interactions with this mock."
        /* given */
        int given = 100;
        /* when then */
        Mockito.when(mockList.size())
                .thenReturn(given);
        /* begin test */
        int expected = 100;
        int actual = mockList.size();
        assertEquals(expected, actual);
    }


    @Test
    void whenUseMockAnnotation_thenMockIsInjected() {
        /* Verify mockList */
        mockedList.add("one");
        Mockito.verify(mockedList).add("one");  //verify is used to check if a mock method was called with required arguments or not.
                                                //if not the test is failed error:"Actually, there were zero interactions with this mock."
        /* begin test */
        assertEquals(0, mockedList.size());

        /* given */
        int given = 100;
        /* when then */
        Mockito.when(mockedList.size())
                .thenReturn(given);
        /* begin test */
        int expected = 100;
        int actual = mockedList.size();
        assertEquals(expected, actual);
    }

}
