package com.assessment_test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",|\n";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(\\[.*?])+\\n");

    public int add(String numbers){
        if(numbers.isEmpty()){
            return 0;
        }

        String delimiter = DEFAULT_DELIMITER;
        if (numbers.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(\\[.*?\\]|.)\n").matcher(numbers);
            if (matcher.find()) {
                String customDelimiter = matcher.group(1);
                delimiter = Pattern.quote(customDelimiter);
                numbers = numbers.substring(matcher.end());
            }
        }

        int sum = 0;
        String[] numArray = numbers.split(delimiter);
        for (String num : numArray) {
            if (!num.isEmpty()) {
                int number = Integer.parseInt(num);
                if(number < 0){
                    throw new IllegalArgumentException("Negative numbers are not allowed");
                }
                sum += number;
            }
        }

        return  sum;
    }
}
