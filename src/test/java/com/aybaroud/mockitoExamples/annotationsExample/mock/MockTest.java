package com.aybaroud.mockitoExamples.annotationsExample.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

/**
 * the difference between spy and mock in Mockito API? Both can be used to mock methods or fields.
 * The difference is that in mock, you are creating a complete mock or fake object while in spy, there is
 * the real object and you just spying or stubbing specific methods of it.
 * When using mock objects, the default behavior of the method when not stub is do nothing. Simple means,
 * if its a void method, then it will do nothing when you call the method or if its a method with a return then it may return null, empty or the default value.
 * While in spy objects, of course, since it is a real method, when you are not stubbing the method, then it will call the real method behavior.
 * If you want to change and mock the method, then you need to stub it.
 */
@ExtendWith(MockitoExtension.class)
class MockTest {

    @Mock
    private List<String> mockedList;

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
