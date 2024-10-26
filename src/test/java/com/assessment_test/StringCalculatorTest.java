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
}
