package com.aybaroud.examples.general;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BeforeAfterTest {

    @BeforeAll
    public static void init(){
        System.out.println("-----Before all init() method is called-----");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Before each setUp() method is called");
    }

    @RepeatedTest(3)
    void testAdd(RepetitionInfo repetitionInfo){
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        System.out.println("Running test number "+repetitionInfo.getCurrentRepetition());
        assertEquals(4,simpleCalculator.add(2,2));
    }

    @AfterEach
    void tearDown() {
        System.out.println("Before each tearDown() method is called");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("-----after all afterAll() method  is called-----");
    }


}