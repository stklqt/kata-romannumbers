package com.example.romannumber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RomanNumber {

    public static void main(String[] args) {
        SpringApplication.run(RomanNumber.class, args);
    }

    public String convertArabicToRomanNumber(int givenNumber) {
        String result = "";

        int thousands = givenNumber / 1000;
        result += times(thousands, "M");

        int hundreds = givenNumber / 100 % 10;
        result += times(hundreds, "C", "D", "M");

        int tens = givenNumber / 10 % 10;
        result += times(tens, "X", "L", "C");

        int ones = givenNumber % 10;
        result += times(ones, "I", "V", "X");


        return result;
    }

    // ------------------------------- Helper Methods --------------------------------------
    private String times(int number, String onesChar, String fivesChar, String tensChar) {
        switch (number) {
            case 0:
                return "";
            case 1:
            case 2:
            case 3:
                return times(number, onesChar);
            case 4:
                return onesChar + fivesChar;
            case 5:
            case 6:
            case 7:
            case 8:
                return fivesChar + times(number - 5, onesChar);
            case 9:
                return onesChar + tensChar;
            default:
                throw new IllegalArgumentException("Only single digits allowed - not " + number);
        }
    }

    private String times(int number, String character) {
        String result = "";
        for (int i = 0; i < number; i++) {
            result += character;
        }
        return result;
    }


}
