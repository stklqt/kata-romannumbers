package com.example.romannumber;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeralConverter {

    private static final Map<Integer, String> DECIMAL_TO_ROMAN = new LinkedHashMap<>();
    private static final Map<Character, Integer> ROMAN_TO_DECIMAL = new LinkedHashMap<>();

    static {
        // Initialize decimal to roman mapping (order matters - descending)
        DECIMAL_TO_ROMAN.put(1000, "M");
        DECIMAL_TO_ROMAN.put(900, "CM");
        DECIMAL_TO_ROMAN.put(500, "D");
        DECIMAL_TO_ROMAN.put(400, "CD");
        DECIMAL_TO_ROMAN.put(100, "C");
        DECIMAL_TO_ROMAN.put(90, "XC");
        DECIMAL_TO_ROMAN.put(50, "L");
        DECIMAL_TO_ROMAN.put(40, "XL");
        DECIMAL_TO_ROMAN.put(10, "X");
        DECIMAL_TO_ROMAN.put(9, "IX");
        DECIMAL_TO_ROMAN.put(5, "V");
        DECIMAL_TO_ROMAN.put(4, "IV");
        DECIMAL_TO_ROMAN.put(1, "I");

        // Initialize roman to decimal mapping
        ROMAN_TO_DECIMAL.put('M', 1000);
        ROMAN_TO_DECIMAL.put('D', 500);
        ROMAN_TO_DECIMAL.put('C', 100);
        ROMAN_TO_DECIMAL.put('L', 50);
        ROMAN_TO_DECIMAL.put('X', 10);
        ROMAN_TO_DECIMAL.put('V', 5);
        ROMAN_TO_DECIMAL.put('I', 1);
    }

    /**
     * Converts a decimal number to Roman numeral representation.
     *
     * @param number the decimal number to convert (must be between 1 and 3999)
     * @return the Roman numeral string
     * @throws IllegalArgumentException if number is out of valid range
     */
    public static String toRoman(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Number must be between 1 and 3999");
        }

        StringBuilder roman = new StringBuilder();
        int remaining = number;

        for (Map.Entry<Integer, String> entry : DECIMAL_TO_ROMAN.entrySet()) {
            int value = entry.getKey();
            String numeral = entry.getValue();

            while (remaining >= value) {
                roman.append(numeral);
                remaining -= value;
            }
        }

        return roman.toString();
    }

    /**
     * Converts a Roman numeral string to its decimal representation.
     *
     * @param roman the Roman numeral string to convert
     * @return the decimal number
     * @throws IllegalArgumentException if the Roman numeral is invalid
     */
    public static int fromRoman(String roman) {
        if (roman == null || roman.isEmpty()) {
            throw new IllegalArgumentException("Roman numeral cannot be null or empty");
        }

        roman = roman.toUpperCase();
        int result = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            char c = roman.charAt(i);
            if (!ROMAN_TO_DECIMAL.containsKey(c)) {
                throw new IllegalArgumentException("Invalid Roman numeral character: " + c);
            }

            int value = ROMAN_TO_DECIMAL.get(c);

            // Subtraction rule: if current value is less than previous, subtract it
            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }

            prevValue = value;
        }

        return result;
    }
}
