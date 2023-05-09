package com.example.demo.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class InstrumentsTest {

    @ParameterizedTest
    @ValueSource(strings = {Instruments.PIANO,Instruments.ACOUSTIC_GUITAR,
            Instruments.BASS,Instruments.electric_guitar})
    public void testImageReferenceExists(String imagePath) {
        assertNotNull(getClass().getResource(imagePath), "Image reference doesn't exist: " + imagePath);
    }
}