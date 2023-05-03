package com.example.demo.strings;

import javafx.scene.media.*;

public class Sounds {

    private static final String CORRECT_SOUND_PATH = "/sounds/correct.mp3";
    private static final String INCORRECT_SOUND_PATH = "/sounds/incorrect.mp3";

    private static Media correctMedia = new Media(Sounds.class.getResource(CORRECT_SOUND_PATH).toString());
    private static Media incorrectMedia = new Media(Sounds.class.getResource(INCORRECT_SOUND_PATH).toString());
    public static void playCorrect() {
        MediaPlayer mediaPlayer = new MediaPlayer(correctMedia);
        mediaPlayer.setOnReady(() -> mediaPlayer.play());

    }

    public static void playIncorrect() {
        MediaPlayer mediaPlayer = new MediaPlayer(incorrectMedia);
       mediaPlayer.setOnReady(() -> mediaPlayer.play());

    }

}
