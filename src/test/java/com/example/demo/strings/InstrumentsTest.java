package com.example.demo.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class InstrumentsTest {

    @ParameterizedTest
    @ValueSource(strings = {Instruments.piano,Instruments.acustic_guitar,
            Instruments.bass,Instruments.electric_guitar})
    public void testImageReferenceExists(String imagePath) {
        assertNotNull(getClass().getResource(imagePath), "Image reference doesn't exist: " + imagePath);
    }
}