package com.example.romannumber.demo;

import lombok.Getter;

@Getter
public enum NumberToRoman {
    X("X", 10),
    IX("IX", 9),
    V("V", 5),
    IV("IV", 4),
    I("I", 1);

    final String romanNumeral;
    final int numeral;

    NumberToRoman(String romanNumeral, int numeral) {
        this.romanNumeral = romanNumeral;
        this.numeral = numeral;
    }
}
