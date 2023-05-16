package com.example.demo.strings;

import org.junit.jupiter.api.Test;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ElectricGuitarTest {

    private static final String[] NOTES = {
            "/instruments/ElectricGuitar/Notes/RE.mp3",
            "/instruments/ElectricGuitar/Notes/MI.mp3",
            "/instruments/ElectricGuitar/Notes/FA.mp3",
            "/instruments/ElectricGuitar/Notes/SOL.mp3",
            "/instruments/ElectricGuitar/Notes/LA.mp3",
            "/instruments/ElectricGuitar/Notes/SI.mp3",
            "/instruments/ElectricGuitar/Notes/DO.mp3",
            "/instruments/ElectricGuitar/Notes/RE_1.mp3",
            "/instruments/ElectricGuitar/Notes/MI_1.mp3",
            "/instruments/ElectricGuitar/Notes/FA_1.mp3",
            "/instruments/ElectricGuitar/Notes/SOL_1.mp3"
    };

    @Test
    public void testSoundFileExistence() {
        for (String note : NOTES) {
            InputStream inputStream = ElectricGuitarTest.class.getResourceAsStream(note);
            assertNotNull(inputStream, "File not found: " + note);
        }
    }
}
