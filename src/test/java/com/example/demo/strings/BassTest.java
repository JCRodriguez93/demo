package com.example.demo.strings;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BassTest {

    private static final String[] NOTES = {
            "/instruments/Bass/Notes/RE.mp3",
            "/instruments/Bass/Notes/MI.mp3",
            "/instruments/Bass/Notes/FA.mp3",
            "/instruments/Bass/Notes/SOL.mp3",
            "/instruments/Bass/Notes/LA.mp3",
            "/instruments/Bass/Notes/SI.mp3",
            "/instruments/Bass/Notes/DO.mp3",
            "/instruments/Bass/Notes/RE_1.mp3",
            "/instruments/Bass/Notes/MI_1.mp3",
            "/instruments/Bass/Notes/FA_1.mp3",
            "/instruments/Bass/Notes/SOL_1.mp3"
    };

    @Test
    public void testSoundFileExistence() {
        for (String note : NOTES) {
            InputStream inputStream = BassTest.class.getResourceAsStream(note);
            assertNotNull(inputStream, "File not found: " + note);
        }
    }
}
