package com.example.romannumber.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RomanNumberTest {

    RomanNumber sut;

    @BeforeEach
    void setUp() {
        sut = new RomanNumber();
    }

    @Test
    void should_convert_1_to_I() {
        assertThat(sut.convert(1)).isEqualTo("I");
    }

    @Test
    void should_convert_3_to_III() {
        assertThat(sut.convert(3)).isEqualTo("III");
    }

    @Test
    void should_convert_5_to_V() {
        assertThat(sut.convert(5)).isEqualTo("V");
    }

    @Test
    void should_convert_4_to_IV() {
        assertThat(sut.convert(4)).isEqualTo("IV");
    }

    @Test
    void should_convert_10_to_X() {
        assertThat(sut.convert(10)).isEqualTo("X");
    }

    @Test
    void should_convert_9_to_IX() {
        assertThat(sut.convert(9)).isEqualTo("IX");
    }

    @Test
    void should_convert_19_to_XVIII() {
        assertThat(sut.convert(18)).isEqualTo("XVIII");
    }
}
