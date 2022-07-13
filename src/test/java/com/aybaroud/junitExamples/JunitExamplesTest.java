package com.aybaroud.junitExamples;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class JunitExamplesTest {

    @BeforeAll
    public static void init(){
        System.out.println("Before all init() method is called");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Before each setUp() method is called");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Before each tearDown() method is called");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("after all afterAll() method  is called");
    }

    /////////////////////////////////////////////////////////////////////////////////////
    ///                          determineLetterGrade                                 ///
    /////////////////////////////////////////////////////////////////////////////////////
    @Test
    void negativeNumberShouldReturnIllegalArgumentException() {
        JunitExamples junitExamples = new JunitExamples();
        assertThrows(IllegalArgumentException.class,
                () -> junitExamples.determineLetterGrade(-1));
    }

    @Test
    void fiftyNineShouldReturnF() {
        JunitExamples junitExamples = new JunitExamples();
        assertEquals('F',junitExamples.determineLetterGrade(59));
    }

    @Test
    void sixtyNineShouldReturnD() {
        JunitExamples junitExamples = new JunitExamples();
        assertEquals('D',junitExamples.determineLetterGrade(69));
    }

    @Test
    void seventyNineShouldReturnC() {
        JunitExamples junitExamples = new JunitExamples();
        assertEquals('C',junitExamples.determineLetterGrade(79));
    }

    @Test
    void eightyNineShouldReturnB() {
        JunitExamples junitExamples = new JunitExamples();
        assertEquals('B',junitExamples.determineLetterGrade(89));
    }

    @Test
    void ninetyNineShouldReturnA() {
        JunitExamples junitExamples = new JunitExamples();
        assertEquals('A',junitExamples.determineLetterGrade(99));
    }

    /////////////////////////////////////////////////////////////////////////////////////
    ///                          add                                                  ///
    /////////////////////////////////////////////////////////////////////////////////////
    @Test
    void twoPlusTwoShouldEqualFour() {
        JunitExamples junitExamples = new JunitExamples();
        assertEquals(4,junitExamples.add(2,2));
        assertNotEquals(5,junitExamples.add(2,2));
        assertTrue(junitExamples.add(2,2) == 4);
    }

    @RepeatedTest(3)
    void testAdd(RepetitionInfo repetitionInfo){
        JunitExamples junitExamples = new JunitExamples();
        System.out.println("Running test number "+repetitionInfo.getCurrentRepetition());
        assertEquals(4,junitExamples.add(2,2));
    }

    /////////////////////////////////////////////////////////////////////////////////////
    ///                          square                                               ///
    /////////////////////////////////////////////////////////////////////////////////////
    @Test
    void testSquare() {
        JunitExamples junitExamples = new JunitExamples();
        int squareOf5 = junitExamples.square(5);
        assertEquals(25,squareOf5);
    }

    /////////////////////////////////////////////////////////////////////////////////////
    ///                          countA                                               ///
    /////////////////////////////////////////////////////////////////////////////////////
    @Test
    void testCountA() {
        JunitExamples junitExamples = new JunitExamples();
        int aNumber = junitExamples.countA("American");
        assertEquals(2,aNumber);
    }

    /////////////////////////////////////////////////////////////////////////////////////
    ///                          truncateAInTheTwoFirstPosition                       ///
    /////////////////////////////////////////////////////////////////////////////////////
    @Test
    void testTruncateAInTheTwoFirstPosition_1() {
        JunitExamples junitExamples = new JunitExamples();
        String actual = junitExamples.truncateAInTheTwoFirstPosition("AACD");
        String expected = "CD";
        assertEquals(actual,expected);
    }

    @Test
    void testTruncateAInTheTwoFirstPosition_2() {
        JunitExamples junitExamples = new JunitExamples();
        String actual = junitExamples.truncateAInTheTwoFirstPosition("ACD");
        String expected = "CD";
        assertEquals(actual,expected);
    }

    /////////////////////////////////////////////////////////////////////////////////////
    ///                          areFirstAndLastTwoCharactersTheSame                  ///
    /////////////////////////////////////////////////////////////////////////////////////
    @Test
    void testAreFirstAndLastTwoCharactersTheSame_1() {
        JunitExamples junitExamples = new JunitExamples();
        boolean actual = junitExamples.areFirstAndLastTwoCharactersTheSame("ABCD");
        boolean expected = false;
        assertEquals(actual,expected);
        assertFalse(actual);
    }

    @Test
    void testAreFirstAndLastTwoCharactersTheSame_2() {
        JunitExamples junitExamples = new JunitExamples();
        boolean actual = junitExamples.areFirstAndLastTwoCharactersTheSame("ABAB");
        boolean expected = true;
        assertEquals(actual,expected);
        assertTrue(actual);
    }


    /////////////////////////////////////////////////////////////////////////////////////
    ///                          divers                                               ///
    /////////////////////////////////////////////////////////////////////////////////////
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
