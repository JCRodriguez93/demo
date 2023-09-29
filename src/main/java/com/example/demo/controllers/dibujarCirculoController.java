package com.example.demo.controllers;

import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.scene.canvas.Canvas;
        import javafx.scene.canvas.GraphicsContext;
        import javafx.scene.layout.AnchorPane;
        import javafx.stage.Stage;
        import javafx.scene.paint.Color;

public class dibujarCirculoController extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("intento.fxml"));
        AnchorPane root = loader.load();

        // Obtén una referencia al lienzo desde tu archivo FXML
        Canvas canvas = (Canvas) root.lookup("#canvas");

        // Configura el lienzo
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLUE);

        // Dibuja el círculo en el lienzo
        gc.fillOval(50, 50, 100, 100); // (x, y, ancho, alto)

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dibujar Círculo con Scene Builder");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


