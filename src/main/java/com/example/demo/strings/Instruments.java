package com.example.demo.strings;

public class Instruments {
   static final String ACOUSTIC_GUITAR = "/instruments/AcousticGuitar/Images/acoustic_guitar.png";
   static final String electric_guitar = "/instruments/ElectricGuitar/electric_guitar.png";
   static final String bass = "/instruments/Bass/bass.png";
   static final String piano = "/instruments/Piano/Images/piano.png";

    public String getAcousticGuitar() {
        return ACOUSTIC_GUITAR;
    }

    public String getElectricGuitar() {
        return electric_guitar;
    }

    public  String getBass() {
        return bass;
    }

    public  String getPiano() {
        return piano;
    }
}
