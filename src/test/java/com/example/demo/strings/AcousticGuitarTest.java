package com.example.demo.strings;

import org.junit.jupiter.api.Test;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
 class AcousticGuitarTest {

     private static final String[] NOTES = {
             "/instruments/AcousticGuitar/Notes/RE.mp3",
             "/instruments/AcousticGuitar/Notes/MI.mp3",
             "/instruments/AcousticGuitar/Notes/FA.mp3",
             "/instruments/AcousticGuitar/Notes/SOL.mp3",
             "/instruments/AcousticGuitar/Notes/LA.mp3",
             "/instruments/AcousticGuitar/Notes/SI.mp3",
             "/instruments/AcousticGuitar/Notes/DO.mp3",
             "/instruments/AcousticGuitar/Notes/RE_1.mp3",
             "/instruments/AcousticGuitar/Notes/MI_1.mp3",
             "/instruments/AcousticGuitar/Notes/FA_1.mp3",
             "/instruments/AcousticGuitar/Notes/SOL_1.mp3"
     };

     @Test
     public void testSoundFileExistence() {
         for (String note : NOTES) {
             InputStream inputStream = AcousticGuitarTest.class.getResourceAsStream(note);
             assertNotNull(inputStream, "File not found: " + note);
         }
     }


}
