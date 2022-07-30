package com.aybaroud.mockitoExamples.annotationsExample.spy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SpyTest {

    @Spy
    private List<String> spiedList;

    //////////////////////////////////////////////////////////////
    //           Spy annotation                                 //
    //////////////////////////////////////////////////////////////
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
        assertEquals(2, spiedList.size());
        /* when spyList.size() is called return 100 */
        Mockito.doReturn(100)
                .when(spiedList)
                .size();

        /* begin test */
        assertEquals(2, spiedList.size());

        assertEquals(100, spiedList.size());
    }

}
