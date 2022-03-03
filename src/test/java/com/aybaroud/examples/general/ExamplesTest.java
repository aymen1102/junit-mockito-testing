package com.aybaroud.examples.general;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ExamplesTest {

    @Test
    void testArraySort(){
        int[] actual = {12,3,8,6};
        int[] expected = {3,6,8,12};
        Arrays.sort(actual);
        assertArrayEquals(expected,actual);
    }

    @Test
    void  testArraySort_Null(){
        int[] actual =null;
        assertArrayEquals(null, actual);
    }
}
