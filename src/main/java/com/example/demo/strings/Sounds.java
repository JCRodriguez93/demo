package com.example.demo.strings;

import javafx.scene.media.*;

import java.util.Objects;

public class Sounds {

    private static final String CORRECT_SOUND_PATH = "/sounds/correct.mp3";
    private static final String INCORRECT_SOUND_PATH = "/sounds/incorrect.mp3";

    private static final Media correctMedia = new Media(Objects.requireNonNull(Sounds.class.getResource(CORRECT_SOUND_PATH)).toString());
    private static final Media incorrectMedia = new Media(Objects.requireNonNull(Sounds.class.getResource(INCORRECT_SOUND_PATH)).toString());
    public static void playCorrect() {
        MediaPlayer mediaPlayer = new MediaPlayer(correctMedia);
        mediaPlayer.setOnReady(mediaPlayer::play);

    }

    public static void playIncorrect() {
        MediaPlayer mediaPlayer = new MediaPlayer(incorrectMedia);
        mediaPlayer.setOnReady(mediaPlayer::play);

    }

}
