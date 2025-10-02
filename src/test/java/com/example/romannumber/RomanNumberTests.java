package com.example.romannumber;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RomanNumberTests {

    @Test
    void contextLoads() {
    }

    // === toRoman() Tests ===

    @Test
    void testToRoman_BasicNumerals() {
        assertEquals("I", RomanNumeralConverter.toRoman(1));
        assertEquals("V", RomanNumeralConverter.toRoman(5));
        assertEquals("X", RomanNumeralConverter.toRoman(10));
        assertEquals("L", RomanNumeralConverter.toRoman(50));
        assertEquals("C", RomanNumeralConverter.toRoman(100));
        assertEquals("D", RomanNumeralConverter.toRoman(500));
        assertEquals("M", RomanNumeralConverter.toRoman(1000));
    }

    @Test
    void testToRoman_SubtractionRules() {
        assertEquals("IV", RomanNumeralConverter.toRoman(4));
        assertEquals("IX", RomanNumeralConverter.toRoman(9));
        assertEquals("XL", RomanNumeralConverter.toRoman(40));
        assertEquals("XC", RomanNumeralConverter.toRoman(90));
        assertEquals("CD", RomanNumeralConverter.toRoman(400));
        assertEquals("CM", RomanNumeralConverter.toRoman(900));
    }

    @Test
    void testToRoman_SimpleAddition() {
        assertEquals("II", RomanNumeralConverter.toRoman(2));
        assertEquals("III", RomanNumeralConverter.toRoman(3));
        assertEquals("VI", RomanNumeralConverter.toRoman(6));
        assertEquals("VII", RomanNumeralConverter.toRoman(7));
        assertEquals("VIII", RomanNumeralConverter.toRoman(8));
        assertEquals("XX", RomanNumeralConverter.toRoman(20));
        assertEquals("XXX", RomanNumeralConverter.toRoman(30));
    }

    @Test
    void testToRoman_ComplexNumbers() {
        assertEquals("XLII", RomanNumeralConverter.toRoman(42));
        assertEquals("XCIX", RomanNumeralConverter.toRoman(99));
        assertEquals("CCCXLIX", RomanNumeralConverter.toRoman(349));
        assertEquals("CDXLIV", RomanNumeralConverter.toRoman(444));
        assertEquals("DCCCXC", RomanNumeralConverter.toRoman(890));
        assertEquals("MCMXCIV", RomanNumeralConverter.toRoman(1994));
        assertEquals("MMXXIII", RomanNumeralConverter.toRoman(2023));
        assertEquals("MMMCMXCIX", RomanNumeralConverter.toRoman(3999));
    }

    @Test
    void testToRoman_InvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.toRoman(0));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.toRoman(-1));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.toRoman(4000));
    }

    // === fromRoman() Tests ===

    @Test
    void testFromRoman_BasicNumerals() {
        assertEquals(1, RomanNumeralConverter.fromRoman("I"));
        assertEquals(5, RomanNumeralConverter.fromRoman("V"));
        assertEquals(10, RomanNumeralConverter.fromRoman("X"));
        assertEquals(50, RomanNumeralConverter.fromRoman("L"));
        assertEquals(100, RomanNumeralConverter.fromRoman("C"));
        assertEquals(500, RomanNumeralConverter.fromRoman("D"));
        assertEquals(1000, RomanNumeralConverter.fromRoman("M"));
    }

    @Test
    void testFromRoman_SubtractionRules() {
        assertEquals(4, RomanNumeralConverter.fromRoman("IV"));
        assertEquals(9, RomanNumeralConverter.fromRoman("IX"));
        assertEquals(40, RomanNumeralConverter.fromRoman("XL"));
        assertEquals(90, RomanNumeralConverter.fromRoman("XC"));
        assertEquals(400, RomanNumeralConverter.fromRoman("CD"));
        assertEquals(900, RomanNumeralConverter.fromRoman("CM"));
    }

    @Test
    void testFromRoman_SimpleAddition() {
        assertEquals(2, RomanNumeralConverter.fromRoman("II"));
        assertEquals(3, RomanNumeralConverter.fromRoman("III"));
        assertEquals(6, RomanNumeralConverter.fromRoman("VI"));
        assertEquals(7, RomanNumeralConverter.fromRoman("VII"));
        assertEquals(8, RomanNumeralConverter.fromRoman("VIII"));
        assertEquals(20, RomanNumeralConverter.fromRoman("XX"));
        assertEquals(30, RomanNumeralConverter.fromRoman("XXX"));
    }

    @Test
    void testFromRoman_ComplexNumbers() {
        assertEquals(42, RomanNumeralConverter.fromRoman("XLII"));
        assertEquals(99, RomanNumeralConverter.fromRoman("XCIX"));
        assertEquals(349, RomanNumeralConverter.fromRoman("CCCXLIX"));
        assertEquals(444, RomanNumeralConverter.fromRoman("CDXLIV"));
        assertEquals(890, RomanNumeralConverter.fromRoman("DCCCXC"));
        assertEquals(1994, RomanNumeralConverter.fromRoman("MCMXCIV"));
        assertEquals(2023, RomanNumeralConverter.fromRoman("MMXXIII"));
        assertEquals(3999, RomanNumeralConverter.fromRoman("MMMCMXCIX"));
    }

    @Test
    void testFromRoman_CaseInsensitive() {
        assertEquals(42, RomanNumeralConverter.fromRoman("xlii"));
        assertEquals(1994, RomanNumeralConverter.fromRoman("mcmxciv"));
        assertEquals(2023, RomanNumeralConverter.fromRoman("MmXxIiI"));
    }

    @Test
    void testFromRoman_InvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.fromRoman(null));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.fromRoman(""));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.fromRoman("ABC"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.fromRoman("XYZ"));
    }

    // === Round-trip Tests ===

    @Test
    void testRoundTrip() {
        for (int i = 1; i <= 3999; i++) {
            String roman = RomanNumeralConverter.toRoman(i);
            int decimal = RomanNumeralConverter.fromRoman(roman);
            assertEquals(i, decimal, "Round-trip failed for " + i + " -> " + roman + " -> " + decimal);
        }
    }

}
