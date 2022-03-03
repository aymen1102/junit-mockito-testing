package com.aybaroud.examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomTest {

    @Test
    void square() {
        Random random = new Random();
        int squareOf5 = random.square(5);
        assertEquals(25,squareOf5);
    }

    @Test
    void countA() {
        Random random = new Random();
        int aNumber = random.countA("American");
        assertEquals(2,aNumber);
    }
}