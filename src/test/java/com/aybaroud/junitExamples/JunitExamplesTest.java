package com.aybaroud.junitExamples;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

// Run with coverage to get % of tested code in JunitExamples class
public class JunitExamplesTest {

    @BeforeAll
    public static void beforeAll(){
        System.out.println("les tests seront exécutés...");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before each...");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each...");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("les tests sont terminés");
    }


    /////////////////////////////////////////////////////////////////////////////////////
    ///                          determineLetterGrade                                 ///
    /////////////////////////////////////////////////////////////////////////////////////
    @Test
    void testNegativeNumberShouldReturnIllegalArgumentException() {
        JunitExamples junitExamples = new JunitExamples();
        assertThrows(IllegalArgumentException.class,
                () -> junitExamples.determineLetterGrade(-1));
    }

    @Test
    void testFiftyNineShouldReturnF() {
        JunitExamples junitExamples = new JunitExamples();
        char expected = 'F';
        char actual = junitExamples.determineLetterGrade(59);
        assertEquals(expected,actual);
    }

    @Test
    void testSixtyNineShouldReturnD() {
        JunitExamples junitExamples = new JunitExamples();
        char expected = 'F';
        char actual = junitExamples.determineLetterGrade(59);
        assertEquals(expected,actual);
    }

    @Test
    void testSeventyNineShouldReturnC() {
        JunitExamples junitExamples = new JunitExamples();
        char expected = 'C';
        char actual = junitExamples.determineLetterGrade(79);
        assertEquals(expected,actual);
    }

    @Test
    void testEightyNineShouldReturnB() {
        JunitExamples junitExamples = new JunitExamples();
        char expected = 'B';
        char actual = junitExamples.determineLetterGrade(89);
        assertEquals(expected,actual);
    }

    @Test
    void testNinetyNineShouldReturnA() {
        JunitExamples junitExamples = new JunitExamples();
        char expected = 'F';
        char actual = junitExamples.determineLetterGrade(59);
        assertEquals(expected,actual);
    }

    /////////////////////////////////////////////////////////////////////////////////////
    ///                          add                                                  ///
    /////////////////////////////////////////////////////////////////////////////////////
    @Test
    void testTwoPlusTwoShouldEqualFour() {
        JunitExamples junitExamples = new JunitExamples();
        int expected = 4;
        int unexpected = 5;
        int actual = junitExamples.add(2, 2);
        assertEquals(expected,actual);
        assertNotEquals(unexpected,actual);
        assertTrue(actual == expected);
    }

    @RepeatedTest(3)
    void testAdd(RepetitionInfo repetitionInfo){
        JunitExamples junitExamples = new JunitExamples();
        System.out.println("Running test number "+repetitionInfo.getCurrentRepetition());
        int expected = 4;
        int actual = junitExamples.add(2, 2);
        assertEquals(expected,actual);
    }

    /////////////////////////////////////////////////////////////////////////////////////
    ///                          square                                               ///
    /////////////////////////////////////////////////////////////////////////////////////
    @Test
    void testSquare() {
        JunitExamples junitExamples = new JunitExamples();
        int expected = 25;
        int actual = junitExamples.square(5);
        assertEquals(expected,actual);
    }

    /////////////////////////////////////////////////////////////////////////////////////
    ///                          countA                                               ///
    /////////////////////////////////////////////////////////////////////////////////////
    @Test
    void testCountA() {
        JunitExamples junitExamples = new JunitExamples();
        int expected = 2;
        int actual = junitExamples.countA("American");
        assertEquals(expected,actual);
    }

    /////////////////////////////////////////////////////////////////////////////////////
    ///                          truncateAInTheTwoFirstPosition                       ///
    /////////////////////////////////////////////////////////////////////////////////////
    @Test
    void testTruncateAInTheTwoFirstPosition_1() {
        JunitExamples junitExamples = new JunitExamples();
        String actual = junitExamples.truncateAInTheTwoFirstPosition("AACD");
        String expected = "CD";
        assertEquals(expected,actual);
    }

    @Test
    void testTruncateAInTheTwoFirstPosition_2() {
        JunitExamples junitExamples = new JunitExamples();
        String actual = junitExamples.truncateAInTheTwoFirstPosition("ACD");
        String expected = "CD";
        assertEquals(expected,actual);
    }

    @Test
    void testTruncateAInTheTwoFirstPosition_3(){
        JunitExamples junitExamples = new JunitExamples();
        String actual = junitExamples.truncateAInTheTwoFirstPosition("AA");
        String expected = "";
        assertEquals(expected,actual);
    }

    /////////////////////////////////////////////////////////////////////////////////////
    ///                          areFirstAndLastTwoCharactersTheSame                  ///
    /////////////////////////////////////////////////////////////////////////////////////
    @Test
    void testAreFirstAndLastTwoCharactersTheSame_1() {
        JunitExamples junitExamples = new JunitExamples();
        boolean actual = junitExamples.areFirstAndLastTwoCharactersTheSame("ABCD");
        boolean expected = false;
        assertEquals(expected,actual);
        assertFalse(actual);
    }

    @Test
    void testAreFirstAndLastTwoCharactersTheSame_2() {
        JunitExamples junitExamples = new JunitExamples();
        boolean actual = junitExamples.areFirstAndLastTwoCharactersTheSame("ABAB");
        boolean expected = true;
        assertEquals(expected,actual);
        assertTrue(actual);
    }

    @Test
    void testAreFirstAndLastTwoCharactersTheSame_3() {
        JunitExamples junitExamples = new JunitExamples();
        boolean actual = junitExamples.areFirstAndLastTwoCharactersTheSame("A");
        boolean expected = false;
        assertEquals(expected,actual);
        assertFalse(actual);
    }

    @Test
    void testAreFirstAndLastTwoCharactersTheSame_4() {
        JunitExamples junitExamples = new JunitExamples();
        boolean actual = junitExamples.areFirstAndLastTwoCharactersTheSame("AA");
        boolean expected = true;
        assertEquals(expected,actual);
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
        int[] expected = null;
        assertArrayEquals(expected, actual);
    }
}
