package com.assessment_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",|\n";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.+)\n");
    List<Integer> negativeNumbers = new ArrayList<>();

    String delimiter = DEFAULT_DELIMITER;

    public String handleDelimiter(String numbers){
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(numbers);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            delimiter = Pattern.quote(customDelimiter);
            numbers = numbers.substring(matcher.end());
        }
        return numbers;
    }

    private void throwNegativeNumbersError(List<Integer> negativeNumbers) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i < negativeNumbers.size();i++){
            if(i != negativeNumbers.size()-1){
                sb.append(negativeNumbers.get(i)+",");
            }else{
                sb.append(negativeNumbers.get(i));
            }
        }

        throw new IllegalArgumentException("Negative numbers are not allowed "+sb);
    }

    public int sum(String[] numArray){
        int sum = 0;
        for (String num : numArray) {
            if (!num.isEmpty()) {
                int number = Integer.parseInt(num);
                if (number < 0) {
                    negativeNumbers.add(number);
                }
                sum += number;
            }
        }

        if(!negativeNumbers.isEmpty()){
            throwNegativeNumbersError(negativeNumbers);
        }

        return sum;
    }

    public int AdditionOfNumbers(String numbers){
        if(numbers.isEmpty()){
            return 0;
        }
        if (numbers.startsWith("//")) {
            numbers = handleDelimiter(numbers);
        }
        String[] numArray = numbers.split(delimiter);
        int result = 0;
        result = sum(numArray);
        return result;
    }
}
