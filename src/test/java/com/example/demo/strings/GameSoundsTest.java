package com.example.demo.strings;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.junit.jupiter.api.Test;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class GameSoundsTest {

    private static final String CORRECT_SOUND_PATH = "/sounds/correct.mp3";
    private static final String INCORRECT_SOUND_PATH = "/sounds/incorrect.mp3";

    private static Media correctMedia = new Media(Objects.requireNonNull(GameSounds.class.getResource(CORRECT_SOUND_PATH)).toString());
    private static Media incorrectMedia = new Media(Objects.requireNonNull(GameSounds.class.getResource(INCORRECT_SOUND_PATH)).toString());
    @Test
    void playCorrect() {
        MediaPlayer mediaPlayer = new MediaPlayer(correctMedia);
        assertNotNull(mediaPlayer);
        mediaPlayer.setOnReady(() -> {
            mediaPlayer.play();
            assertSame(mediaPlayer.getStatus(), MediaPlayer.Status.PLAYING);
        });
    }

    @Test
    void playIncorrect() {
        MediaPlayer mediaPlayer = new MediaPlayer(incorrectMedia);
        assertNotNull(mediaPlayer);
        mediaPlayer.setOnReady(() -> {
            mediaPlayer.play();
            assertSame(mediaPlayer.getStatus(), MediaPlayer.Status.PLAYING);

        });
    }
}