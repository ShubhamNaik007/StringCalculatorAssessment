package com.assessment_test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    void add_emptyString(){
        assertEquals(0,calculator.add(""));
    }

    @Test
    void add_forSingleNumber(){
        assertEquals(1,calculator.add("1"));
    }

    @Test
    void add_forMultipleNumbers(){
        assertEquals(6,calculator.add("1,5"));
    }

    @Test
    void add_forHandleAnyNumbers(){
        assertEquals(100,calculator.add("10,10,10,10,10,50"));
    }

    @Test
    void add_forNewNumbersLineFormat(){
        assertEquals(6,calculator.add("1\n2,3"));
    }


    @Test
    void add_forDelimiterFormat(){
        assertEquals(3,calculator.add("//;\n1;2"));
    }

    @Test
    void add_forNegativeNumberFormat(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,3,-4");
        });
        assertEquals("Negative numbers are not allowed -2,-4",exception.getMessage());
    }
}
