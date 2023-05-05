package com.example.demo;

import com.example.demo.strings.*;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import java.util.Arrays;



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
    private Button btn_listen;
    @FXML
    private ImageView instrument_pic = new ImageView();

    Notes musicalNotes = new Notes();
    List<String> availableNotes = new ArrayList<>();
    List<String> buttonNotes = new ArrayList<>();

    private String correctNote;
    private final Instruments instruments = new Instruments();



    @Override
    public void initialize(URL url, ResourceBundle rb) {

        getAvailableNotes();
        restartGame();
        selectInstrument();
        loadInstrumentPics();


    }

    private void loadInstrumentPics() {
        Map<String, String> instrumentImageMap = new HashMap<>();
        instrumentImageMap.put("Acoustic Guitar", instruments.getAcustic_guitar());
        instrumentImageMap.put("Electric Guitar", instruments.getElectric_guitar());
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
                "Acoustic Guitar",
                "Electric Guitar",
                "Bass",
                "Piano"
        );

        instrument_selec.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<>(instrumentList));
        instrument_selec.valueProperty().addListener((observable, oldValue, newValue) -> {
            // Hacer algo con el elemento seleccionado
        });
    }


    @FXML
    private void onClickA(ActionEvent event) {
        checkResponse(AOption);
    }

    @FXML
    private void onClickB(ActionEvent event) {
        checkResponse(BOption);
    }

    @FXML
    private void onClickC(ActionEvent event) {
        checkResponse(COption);
    }

    @FXML
    private void onClickD(ActionEvent event) {
        checkResponse(DOption);
    }

    private void checkResponse(Button button) {
        String response = button.getText();

        if (correctNote.contains(response)) {
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
        Sounds.playIncorrect();
        Platform.runLater(() -> {

            Background originalBackground = button.getBackground();
            button.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> button.setBackground(originalBackground));
            pause.play();
        });
    }

    private void isCorrect(Button button) {
        Sounds.playCorrect();
        Platform.runLater(() -> {
            Background originalBackground = button.getBackground();
            button.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> button.setBackground(originalBackground));
            pause.play();
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
        suffleNotes();
        Collections.shuffle(buttonNotes);
        Random random = new Random();
        int i = random.nextInt(buttonNotes.size());
        correctNote = buttonNotes.get(i);
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(correctNote)));
        note.setImage(image);
        updateButtons();
    }

    private void updateButtons() {
        AOption.setText(getNoteImage(buttonNotes.get(0)));
        BOption.setText(getNoteImage(buttonNotes.get(1)));
        COption.setText(getNoteImage(buttonNotes.get(2)));
        DOption.setText(getNoteImage(buttonNotes.get(3)));
    }

    private void suffleNotes() {
        Collections.shuffle(availableNotes);
        buttonNotes = new ArrayList();
        for (int i = 0; i < 4; i++) {
            buttonNotes.add(availableNotes.get(i));
        }
    }

    private void getAvailableNotes() {
        availableNotes = new ArrayList<>(
                Arrays.asList(musicalNotes.getDO(),
                        musicalNotes.getRE(),
                        musicalNotes.getMI(),
                        musicalNotes.getFA(),
                        musicalNotes.getSOL(),
                        musicalNotes.getLA(),
                        musicalNotes.getSI(),
                        musicalNotes.getRE_8(),
                        musicalNotes.getMI_8(),
                        musicalNotes.getFA_8(),
                        musicalNotes.getSOL_8()));
    }

    private String getNoteImage(String imagen) {
        int inicio = imagen.lastIndexOf("/") + 1;
        int fin = imagen.lastIndexOf(".");
        return imagen.substring(inicio, fin);
    }

}