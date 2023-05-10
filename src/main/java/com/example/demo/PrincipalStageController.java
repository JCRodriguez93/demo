package com.example.demo;

import com.example.demo.instruments.*;
import com.example.demo.strings.*;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.*;


public class PrincipalStageController implements Initializable {

    @FXML
    private ImageView note;
    @FXML
    private Button AOption;
    @FXML
    private Button BOption;
    @FXML
    private Button COption;
    @FXML
    private Button DOption;
    @FXML
    private Text resultado;
    @FXML
    private Spinner<String> instrument_selec = new Spinner<>();
    @FXML
    private ImageView instrument_pic = new ImageView();

    PentagramNotes musicalPentagramNotes = new PentagramNotes();
    List<String> availableNotes = new ArrayList<>();
    List<String> buttonNotes = new ArrayList<>();

    private String correctNote;
    private final Instruments instruments = new Instruments();
    private boolean isAnimating = false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        loadInstrumentPics();
        getAvailableNotes();
        restartGame();
        selectInstrument();
    }

    private void loadInstrumentPics() {
        Map<String, String> instrumentImageMap = new HashMap<>();
        instrumentImageMap.put("Acoustic Guitar", instruments.getAcousticGuitar());
        instrumentImageMap.put("Electric Guitar", instruments.getElectricGuitar());
        instrumentImageMap.put("Bass", instruments.getBass());
        instrumentImageMap.put("Piano", instruments.getPiano());
        instrument_selec.valueProperty().addListener((observable, oldValue, newValue) -> {
            String imagePath = instrumentImageMap.get(newValue);
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
            instrument_pic.setImage(image);
        });
    }

    private void selectInstrument() {
        ObservableList<String> instrumentList = FXCollections.observableArrayList(
                "Acoustic Guitar","Electric Guitar", "Bass", "Piano" );
        instrument_selec.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<>(instrumentList));

    }


    @FXML
    private void onClickA() {
        checkResponse(AOption);
    }

    @FXML
    private void onClickB() {
        checkResponse(BOption);
    }

    @FXML
    private void onClickC() {
        checkResponse(COption);
    }

    @FXML
    private void onClickD() {
        checkResponse(DOption);
    }

    @FXML
    private void onClickListen() {

        switch (instrument_selec.getValue()){
            case "Acoustic Guitar" -> AcousticGuitar.play(getSubstringNotes(correctNote));
            case "Bass" -> Bass.play(getSubstringNotes(correctNote));
            case "Electric Guitar" -> ElectricGuitar.play(getSubstringNotes(correctNote));
            case "Piano" -> Piano.play(getSubstringNotes(correctNote));
        }


    }

    private void checkResponse(Button button) {
        String response = button.getText();
        String correct = getSubstringNotes(correctNote);

        if (correct.equals(response)) {
            this.resultado.setFill(Color.GREEN);
            this.resultado.setText("CORRECTO");
            isCorrect(button);
        } else {
            this.resultado.setFill(Color.RED);
            this.resultado.setText("INCORRECTO");
            isIncorrect(button);
        }
        restartGame();
        changeImage();
    }

    private void isIncorrect(Button button) {
        GameSounds.playIncorrect();
        Platform.runLater(() -> {
            if (!isAnimating) {
                isAnimating = true;
                Background originalBackground = button.getBackground();
                button.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(event -> {
                    button.setBackground(originalBackground);
                    isAnimating = false;
                });
                pause.play();
            }
        });
    }

    private void isCorrect(Button button) {
        GameSounds.playCorrect();
        Platform.runLater(() -> {
            if (!isAnimating) {
                isAnimating = true;
                Background originalBackground = button.getBackground();
                button.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(event -> {
                    button.setBackground(originalBackground);
                    isAnimating = false;
                });
                pause.play();
            }
        });
    }

    public void changeImage() {
        Random random = new Random();
        int i = random.nextInt(buttonNotes.size());
        correctNote = buttonNotes.get(i);
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(correctNote)));
        note.setImage(image);
    }

    public void restartGame() {
        getAvailableNotes();
        shuffleNotes();
        Collections.shuffle(buttonNotes);
        Random random = new Random();
        int i = random.nextInt(buttonNotes.size());
        correctNote = buttonNotes.get(i);
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(correctNote)));
        note.setImage(image);
        updateButtons();
    }

    private void updateButtons() {
        AOption.setText(getSubstringNotes(buttonNotes.get(0)));
        BOption.setText(getSubstringNotes(buttonNotes.get(1)));
        COption.setText(getSubstringNotes(buttonNotes.get(2)));
        DOption.setText(getSubstringNotes(buttonNotes.get(3)));
    }

    private void shuffleNotes() {
        Collections.shuffle(availableNotes);
        buttonNotes = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            buttonNotes.add(availableNotes.get(i));
        }
    }

    private void getAvailableNotes() {
        availableNotes = new ArrayList<>(
                Arrays.asList(musicalPentagramNotes.getDO(),
                        musicalPentagramNotes.getRE(),
                        musicalPentagramNotes.getMI(),
                        musicalPentagramNotes.getFA(),
                        musicalPentagramNotes.getSOL(),
                        musicalPentagramNotes.getLA(),
                        musicalPentagramNotes.getSI(),
                        musicalPentagramNotes.getRE_8(),
                        musicalPentagramNotes.getMI_8(),
                        musicalPentagramNotes.getFA_8(),
                        musicalPentagramNotes.getSOL_8()));
    }

    private String getSubstringNotes(String note) {
        int inicio = note.lastIndexOf("/") + 1;
        int fin = note.lastIndexOf(".");
        return note.substring(inicio, fin);
    }

}
