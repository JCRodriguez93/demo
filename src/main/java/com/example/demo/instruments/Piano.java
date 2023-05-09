package com.example.demo.instruments;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.Objects;

public class Piano {

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

    private static final Media[] NOTES_MEDIA = new Media[NOTES.length];

    static {
        for (int i = 0; i < NOTES_MEDIA.length; i++) {
            NOTES_MEDIA[i] = new Media(Objects.requireNonNull(AcousticGuitar.class.getResource(NOTES[i])).toString());
        }
    }

    public static void play(String note) {
        switch (note) {
            case "RE" -> {
                MediaPlayer mediaPlayerRe = new MediaPlayer(NOTES_MEDIA[0]);
                mediaPlayerRe.setOnReady(mediaPlayerRe::play);
            }
            case "MI" -> {
                MediaPlayer mediaPlayerMi = new MediaPlayer(NOTES_MEDIA[1]);
                mediaPlayerMi.setOnReady(mediaPlayerMi::play);
            }
            case "FA" -> {
                MediaPlayer mediaPlayerFa = new MediaPlayer(NOTES_MEDIA[2]);
                mediaPlayerFa.setOnReady(mediaPlayerFa::play);
            }
            case "SOL" -> {
                MediaPlayer mediaPlayerSol = new MediaPlayer(NOTES_MEDIA[3]);
                mediaPlayerSol.setOnReady(mediaPlayerSol::play);
            }
            case "LA" -> {
                MediaPlayer mediaPlayerLa = new MediaPlayer(NOTES_MEDIA[4]);
                mediaPlayerLa.setOnReady(mediaPlayerLa::play);
            }
            case "SI" -> {
                MediaPlayer mediaPlayerSi = new MediaPlayer(NOTES_MEDIA[5]);
                mediaPlayerSi.setOnReady(mediaPlayerSi::play);
            }
            case "DO" -> {
                MediaPlayer mediaPlayerDo = new MediaPlayer(NOTES_MEDIA[6]);
                mediaPlayerDo.setOnReady(mediaPlayerDo::play);
            }
            case "RE_1" -> {
                MediaPlayer mediaPlayerRe1 = new MediaPlayer(NOTES_MEDIA[7]);
                mediaPlayerRe1.setOnReady(mediaPlayerRe1::play);
            }
            case "MI_1" -> {
                MediaPlayer mediaPlayerMi1 = new MediaPlayer(NOTES_MEDIA[8]);
                mediaPlayerMi1.setOnReady(mediaPlayerMi1::play);
            }
            case "FA_1" -> {
                MediaPlayer mediaPlayerFa1 = new MediaPlayer(NOTES_MEDIA[9]);
                mediaPlayerFa1.setOnReady(mediaPlayerFa1::play);
            }
            case "SOL_1" -> {
                MediaPlayer mediaPlayerSol1 = new MediaPlayer(NOTES_MEDIA[10]);
                mediaPlayerSol1.setOnReady(mediaPlayerSol1::play);
            }
            default -> System.out.println("Nota no válida");
        }
    }
}
