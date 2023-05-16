package com.example.demo.strings;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PianoTest {

    private static final String[] NOTES = {
            "/instruments/Piano/Notes/RE.mp3",
            "/instruments/Piano/Notes/MI.mp3",
            "/instruments/Piano/Notes/FA.mp3",
            "/instruments/Piano/Notes/SOL.mp3",
            "/instruments/Piano/Notes/LA.mp3",
            "/instruments/Piano/Notes/SI.mp3",
            "/instruments/Piano/Notes/DO.mp3",
            "/instruments/Piano/Notes/RE_1.mp3",
            "/instruments/Piano/Notes/MI_1.mp3",
            "/instruments/Piano/Notes/FA_1.mp3",
            "/instruments/Piano/Notes/SOL_1.mp3"
    };

    @Test
    public void testSoundFileExistence() {
        for (String note : NOTES) {
            InputStream inputStream = PianoTest.class.getResourceAsStream(note);
            assertNotNull(inputStream, "File not found: " + note);
        }
    }
}
