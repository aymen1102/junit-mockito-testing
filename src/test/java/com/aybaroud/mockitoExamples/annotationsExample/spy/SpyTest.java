package com.aybaroud.mockitoExamples.annotationsExample.spy;

import com.aybaroud.mockitoExamples.annotationsExample.MathUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
class SpyTest {

    @Spy
    List<String> spiedList;
    @Spy
    private MathUtils mathUtils;

    @Test
    void whenNotUseSpyAnnotation_thenCorrect() {
        List<String> spyList = Mockito.spy(ArrayList.class);
        /* Verify spyList */
        spyList.add("one");
        spyList.add("two");
        Mockito.verify(spyList).add("one");
        Mockito.verify(spyList).add("two");

        /* begin test 1 */
        assertEquals(2, spyList.size());

        /* when spyList.size() is called return 100 */
        Mockito.doReturn(100)
                .when(spyList)
                .size();

        /* begin test 2 */
        assertEquals(100, spyList.size());
    }

    @Test
    void whenUseSpyAnnotation_thenSpyIsInjectedCorrectly() {
        /* Verify spyList */
        spiedList.add("one");
        spiedList.add("two");
        Mockito.verify(spiedList).add("one");
        Mockito.verify(spiedList).add("two");

        /* begin test 1 */
        //assertEquals(2, spiedList.size());

        /* when spyList.size() is called return 100 */
        Mockito.doReturn(100)
                .when(spiedList)
                .size();

        /* begin test 2 */
        assertEquals(100, spiedList.size());
    }

    @Test
    void testSumUsingSpy(){
        /* given */
        int given = 5;
        /* when then */
        Mockito.when(mathUtils.add(1,1))
                .thenReturn(given);

        /* begin test */
        assertEquals(5,mathUtils.add(1,1));  // mocked method
        assertEquals(7,mathUtils.add(5,2));  // real method called since it's not stubbed
    }
}
