package com.aybaroud.examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    @Test
    void twoPlusTwoShouldEqualFour() {
        SimpleCalculator simpleCalculator = new SimpleCalculator();

        assertEquals(4,simpleCalculator.add(2,2));

        assertNotEquals(5,simpleCalculator.add(2,2));

        assertTrue(simpleCalculator.add(2,2) == 4);

    }

}