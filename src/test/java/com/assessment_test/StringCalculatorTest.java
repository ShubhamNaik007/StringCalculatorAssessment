package com.assessment_test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    void AdditionOfNumbers_emptyString(){
        assertEquals(0,calculator.AdditionOfNumbers(""));
    }

    @Test
    void AdditionOfNumbers_forSingleNumber(){
        assertEquals(1,calculator.AdditionOfNumbers("1"));
    }

    @Test
    void AdditionOfNumbers_forMultipleNumbers(){
        assertEquals(6,calculator.AdditionOfNumbers("1,5"));
    }

    @Test
    void AdditionOfNumbers_forHandleAnyNumbers(){
        assertEquals(100,calculator.AdditionOfNumbers("10,10,10,10,10,50"));
    }

    @Test
    void AdditionOfNumbers_forNewNumbersLineFormat(){
        assertEquals(6,calculator.AdditionOfNumbers("1\n2,3"));
    }


    @Test
    void AdditionOfNumbers_forDelimiterFormat(){
        assertEquals(3,calculator.AdditionOfNumbers("//;\n1;2"));
    }

    @Test
    void AdditionOfNumbers_forNegativeNumberFormat(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.AdditionOfNumbers("1,-2,3,-4");
        });
        assertEquals("Negative numbers are not allowed -2,-4",exception.getMessage());
    }

    @Test
    void AdditionOfNumbers_forDelimiterPipeFormat(){
        assertEquals(3,calculator.AdditionOfNumbers("//|\n1|2"));
    }

}
