package com.example.romannumber.demo;

public class RomanNumber {

    public String convert(int arabic) {
        for (NumberToRoman ntr: NumberToRoman.values()) {
            if (arabic > ntr.getNumeral()) {
                return ntr.getRomanNumeral() + convert(arabic - ntr.getNumeral());
            } else if (arabic == ntr.getNumeral()) {
                return ntr.getRomanNumeral();
            }
        }

        return "";
    }

}
