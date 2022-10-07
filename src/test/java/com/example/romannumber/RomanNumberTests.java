package com.example.romannumber;

import com.tngtech.junit.dataprovider.DataProvider;
import com.tngtech.junit.dataprovider.UseDataProvider;
import com.tngtech.junit.dataprovider.UseDataProviderExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest
@ExtendWith(UseDataProviderExtension.class)
class RomanNumberTests {

    @Test
    void contextLoads() {
    }

    @Test
    void should_return_first_number() {
        // given

        // then
        RomanNumber number = new RomanNumber();
        String convertedNumber = number.convertArabicToRomanNumber(1);

        // when
        assertThat(convertedNumber).isEqualTo("I");
    }


    @DataProvider
    static Object[][] dataProviderRomanNumbers() {
        return new Object[][]{
                {"I", 1},
                {"II", 2},
                {"III", 3},
                {"IV", 4},
                {"V", 5},
                {"VI", 6},
                {"VIII", 8},
                {"IX", 9},
                {"X", 10},
                {"XI", 11},
                {"XIV", 14},
                {"CCLVI", 256}
        };
    }

    @TestTemplate
    @UseDataProvider("dataProviderRomanNumbers")
    void shouldTestSomeRomanNumbers(String expectedRomanNumber, int givenArabicNumber) {
        System.out.println(expectedRomanNumber + "    " + givenArabicNumber);
        RomanNumber romanNumber = new RomanNumber();

        assertThat(romanNumber.convertArabicToRomanNumber(givenArabicNumber)).isEqualTo(expectedRomanNumber);
    }

//    https://github.com/froderik/roman_numeral_katas/blob/master/java/RomanNumber.java
//    http://www.novaroma.org/via_romana/numbers.html
}
