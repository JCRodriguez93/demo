package com.example.demo.strings;

public class Instruments {
   static final String ACOUSTIC_GUITAR = "/instruments/AcousticGuitar/Images/acoustic_guitar.png";
   static final String electric_guitar = "/instruments/ElectricGuitar/Images/electric_guitar.png";
   static final String BASS = "/instruments/Bass/Images/bass.png";
   static final String PIANO = "/instruments/Piano/Images/piano.png";

    public String getAcousticGuitar() {
        return ACOUSTIC_GUITAR;
    }

    public String getElectricGuitar() {
        return electric_guitar;
    }

    public  String getBass() {
        return BASS;
    }

    public  String getPiano() {
        return PIANO;
    }
}
