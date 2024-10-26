package com.assessment_test;

import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers){
        if(numbers.isEmpty()){
            return 0;
        }

        String delimiter = ",|\n";
        int sum = 0;
        String[] numArray = numbers.split(delimiter);
        for (String num : numArray) {
            if (!num.isEmpty()) {
                int number = Integer.parseInt(num);
                sum += number;
            }
        }

        return  sum;
    }
}
