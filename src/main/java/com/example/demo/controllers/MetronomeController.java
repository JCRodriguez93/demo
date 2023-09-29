package com.example.demo.controllers;
import com.example.demo.strings.GameSounds;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.Objects;

public class MetronomeController {

    @FXML
    Button metroPlay;
    @FXML
    Button metroStop;
    @FXML
    Button metroUp;
    @FXML
    Button metroDown;
    @FXML
    Button metroCompas;
    @FXML
    TextField bps;

    private MediaPlayer mediaPlayer;
    private static final String metro = "/sounds/metronome.mp3";
    private  static final String drum = "/sounds/drumstick.mp3";
    private static final Media METRONOME = new Media(Objects.requireNonNull(GameSounds.class.getResource(metro)).toString());
    private static final Media DRUMSTICK = new Media(Objects.requireNonNull(GameSounds.class.getResource(drum)).toString());

    private double bpsValue;  // Mover la declaración aquí
    private boolean isPlaying;
    @FXML
    private void initialize() {
        // Inicializar el ritmo (BPM) con un valor predeterminado
        bpsValue = Double.parseDouble(bps.getText());
        isPlaying = false;
    }
    @FXML
    private void OnClickPlay(){

    if (!isPlaying) {  // Evita iniciar otro metrónomo si ya está reproduciendo
            double beatDurationMillis = 60000.0 / bpsValue;
            mediaPlayer = new MediaPlayer(METRONOME);
            double targetRate = METRONOME.getDuration().toMillis() / beatDurationMillis;
            mediaPlayer.setRate(targetRate);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();
            isPlaying = true;
        }
    }
    @FXML
    private void OnClickStop(){
        if (isPlaying) {  // Evita detener si no está reproduciendo
            mediaPlayer.stop();
            isPlaying = false;
        }
        }



    @FXML
    private void OnClickUp(){
        incrementBps(1.0);
    }
    @FXML
    private void OnClickDown(){
        incrementBps(-1.0);

    }
    @FXML
    private void OnClickCompas(){
        System.out.println("soy el que cambia el compás");
    }

    private void incrementBps(double increment) {
        bpsValue += increment;
        updateMetronomeSpeed();
        System.out.println("Ritmo cambiado a: " + bpsValue + " BPM");
    }
    private void updateMetronomeSpeed() {
        if (mediaPlayer != null) {
            // Determina la duración de un beat en milisegundos
            double beatDurationMillis = 60000.0 / bpsValue;
            bps.setText(String.valueOf(bpsValue));

            // Calcula la velocidad para mantener la duración del beat constante
            double targetRate = METRONOME.getDuration().toMillis() / beatDurationMillis;

            // Configura la velocidad del MediaPlayer
            mediaPlayer.setRate(targetRate);
        }


    }}

