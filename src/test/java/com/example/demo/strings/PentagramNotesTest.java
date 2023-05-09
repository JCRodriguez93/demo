package com.example.demo.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PentagramNotesTest {


    @ParameterizedTest
    @ValueSource(strings = {"/pentagrams/DO.png", "/pentagrams/RE.png", "/pentagrams/MI.png",
            "/pentagrams/FA.png", "/pentagrams/SOL.png", "/pentagrams/LA.png", "/pentagrams/SI.png",
            "/pentagrams/RE_1.png", "/pentagrams/MI_1.png", "/pentagrams/FA_1.png", "/pentagrams/SOL_1.png"})
    public void testImageReferenceExists(String imagePath) {
        assertNotNull(getClass().getResource(imagePath), "Image reference doesn't exist: " + imagePath);
    }


}