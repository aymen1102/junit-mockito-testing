package com.aybaroud.mockitoExamples.annotationsExample.mockVsSpy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * the difference between spy and mock in Mockito API? Both can be used to mock methods or fields.
 * The difference is that in mock, you are creating a complete mock or fake object while in spy, there is
 * the real object and you just spying or stubbing specific methods of it.
 * When using mock objects, the default behavior of the method when not stub is do nothing. Simple means,
 * if its a void method, then it will do nothing when you call the method or if its a method with a return then it may return null, empty or the default value.
 * While in spy objects, of course, since it is a real method, when you are not stubbing the method, then it will call the real method behavior.
 * If you want to change and mock the method, then you need to stub it.
 * If you want to be safe and avoid calling external services and just want to test the logic inside of the unit, then use mock.
 * If you want to call external service and perform calling of real dependency, or simply say, you want to run the program as
 * it is and just stub specific methods, then use spy. So that’s the difference between spy and mock in mockito.
 */
@ExtendWith(MockitoExtension.class)
class MockVsSpy {
    @Mock
    private List<String> mockList;

    @Spy
    private List<String> spyList;

    @Test
    void testMockList() {
        //by default, calling the methods of mock object will do nothing
        mockList.add("test");
        assertNull(mockList.get(0));
    }

    @Test
    void testSpyList() {
        spyList = new ArrayList<>();
        //spy object will call the real method when not stub
        spyList.add("test");
        String expected = "test";
        String actual = spyList.get(0);
        assertEquals(expected,actual);
    }

    @Test
    void testMockWithStub() {
        //try stubbing a method
        String expected = "Mock 100";
        Mockito.when(mockList.get(100))
                .thenReturn(expected);
        assertEquals(expected, mockList.get(100));
    }

    @Test
    void testSpyWithStub() {
        //stubbing a spy method will result the same as the mock object
        String expected = "Spy 100";
        //take note of using doReturn instead of when
        Mockito.doReturn(expected)
                .when(spyList)
                .get(100);
        assertEquals(expected, spyList.get(100));
    }
}
