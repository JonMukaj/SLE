package com.example.jonsle.View;

import com.example.jonsle.Controller.HomeController;
import com.example.jonsle.Controller.MenuController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Home {

    private final AnchorPane anchorPane;
    private final Button inverseBt;
    private final Button luBt;
    private final Text inverseTxt;
    private final Text luTxt;

    public Home(Stage stage) {

        anchorPane = new AnchorPane();
        inverseBt = new Button();
        luBt = new Button();
        inverseTxt = new Text();
        luTxt = new Text();

        anchorPane.setPrefHeight(700.0);
        anchorPane.setPrefWidth(1000.0);
        anchorPane.getStyleClass().add("main");
        anchorPane.getStylesheets().add(this.getClass().getResource("/style.css").toExternalForm());

        inverseBt.setLayoutX(162.0);
        inverseBt.setLayoutY(437.0);
        inverseBt.setText("INVERSE");
        inverseBt.setFont(new Font("Algerian", 32.0));
        inverseBt.setPrefHeight(104.0);
        inverseBt.setPrefWidth(248.0);
        inverseBt.setStyle("-fx-background-radius: 15;");
        inverseBt.getStyleClass().add("inverse");
        inverseBt.setOnAction(actionEvent -> {
            HomeController.createInverseMenu(stage);
        });

        luBt.setLayoutX(572.0);
        luBt.setLayoutY(437.0);
        luBt.setText("LOWER-UPPER");
        luBt.setFont(new Font("Algerian", 32.0));
        luBt.setPrefHeight(104.0);
        luBt.setPrefWidth(260.0);
        luBt.setStyle("-fx-background-radius: 15;");
        luBt.getStyleClass().add("inverse");
        luBt.setOnAction(actionEvent -> {
            HomeController.createLuMenu(stage);
        });


        anchorPane.getChildren().add(inverseBt);
        anchorPane.getChildren().add(luBt);
        anchorPane.getChildren().add(inverseTxt);
        anchorPane.getChildren().add(luTxt);

    }

    public Scene createHomeScene () {
        Scene scene = new Scene(anchorPane,1000,700);
        return scene;
    }

}
