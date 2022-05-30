package com.example.jonsle.View;

import com.example.jonsle.Controller.MenuController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class Menu{

    protected final AnchorPane anchorPane;
    protected final TextArea txtArea;
    protected final TextField txtField;
    protected final Button backBt;
    protected final Button generateBt;
    protected final Button matricesBt;
    protected final Button equationBt;
    protected final Button infoBt;
    protected final Button solutionBt;
    protected final Button normalizedBt;
    protected final Button eigenBt;

    public Menu(Stage stage, Scene old) {
        anchorPane = new AnchorPane();
        txtArea = new TextArea();
        txtField = new TextField();
        generateBt = new Button();
        backBt = new Button();
        matricesBt = new Button();
        solutionBt = new Button();
        equationBt = new Button();
        infoBt = new Button();
        normalizedBt = new Button();
        eigenBt = new Button();

        anchorPane.setPrefHeight(700.0);
        anchorPane.setPrefWidth(1000.0);
        anchorPane.getStyleClass().add("inv");


        txtArea.setLayoutX(31.0);
        txtArea.setLayoutY(123.0);
        txtArea.setPrefHeight(561.0);
        txtArea.setPrefWidth(620.0);
        txtArea.setPromptText("Result");
        txtArea.setFont(new Font("Franklin Gothic Medium",28));


        txtField.setLayoutX(30.0);
        txtField.setLayoutY(75.0);
        txtField.setPrefHeight(38.0);
        txtField.setPrefWidth(451.0);
        txtField.setPromptText("Enter number of unknowns:");
        txtField.setFont(new Font("Arial Black", 18.0));

        generateBt.setLayoutX(504.0);
        generateBt.setLayoutY(73.0);
        generateBt.setPrefHeight(38.0);
        generateBt.setPrefWidth(112.0);
        generateBt.setStyle("-fx-background-radius: 15;");
        generateBt.getStyleClass().add("generate");
        generateBt.setText("GENERATE");
        generateBt.setFont(new Font(18.0));

        backBt.setLayoutX(863.0);
        backBt.setLayoutY(24.0);
        backBt.setPrefHeight(40.0);
        backBt.setPrefWidth(92.0);
        backBt.setStyle("-fx-background-radius: 15;");
        backBt.getStyleClass().add("back");
        backBt.setText("BACK");
        backBt.setFont(new Font(18.0));
        backBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MenuController.returnHome(old,stage);
            }
        });

        matricesBt.setLayoutX(704.0);
        matricesBt.setLayoutY(119.0);
        matricesBt.setPrefHeight(58.0);
        matricesBt.setPrefWidth(256.0);
        matricesBt.setStyle("-fx-background-radius: 15;");
        matricesBt.getStyleClass().add("action");
        matricesBt.setText("MATRICES");
        matricesBt.setFont(new Font(35.0));
        matricesBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    MenuController.showMatrices(txtArea);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        solutionBt.setLayoutX(706.0);
        solutionBt.setLayoutY(214.0);
        solutionBt.setPrefHeight(70.0);
        solutionBt.setPrefWidth(256.0);
        solutionBt.setStyle("-fx-background-radius: 15;");
        solutionBt.getStyleClass().add("action");
        solutionBt.setText("SOLUTION");
        solutionBt.setFont(new Font(35.0));
        solutionBt.setOnAction(actionEvent -> {
            try {
                MenuController.showSolution(txtArea);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        equationBt.setLayoutX(705.0);
        equationBt.setLayoutY(309.0);
        equationBt.setPrefHeight(70.0);
        equationBt.setPrefWidth(256.0);
        equationBt.setStyle("-fx-background-radius: 15;");
        equationBt.getStyleClass().add("action");
        equationBt.setText("EQUATION");
        equationBt.setFont(new Font(35.0));
        equationBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    MenuController.openEquation();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        infoBt.setLayoutX(707.0);
        infoBt.setLayoutY(408.0);
        infoBt.setPrefHeight(54.0);
        infoBt.setPrefWidth(256.0);
        infoBt.setStyle("-fx-background-radius: 15;");
        infoBt.getStyleClass().add("action");
        infoBt.setText("INFO");
        infoBt.setFont(new Font(35.0));
        infoBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    MenuController.showInfo(txtArea);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        normalizedBt.setLayoutX(706.0);
        normalizedBt.setLayoutY(501.0);
        normalizedBt.setPrefHeight(77.0);
        normalizedBt.setPrefWidth(256.0);
        normalizedBt.setStyle("-fx-background-radius: 15;");
        normalizedBt.getStyleClass().add("action");
        normalizedBt.setText("NORMALIZED");
        normalizedBt.setFont(new Font(32.0));
        normalizedBt.setOnAction(actionEvent -> {
            try {
                MenuController.showNormalized(txtArea);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


        eigenBt.setLayoutX(704.0);
        eigenBt.setLayoutY(597.0);
        eigenBt.setPrefHeight(53.0);
        eigenBt.setPrefWidth(256.0);
        eigenBt.setStyle("-fx-background-radius: 15;");
        eigenBt.getStyleClass().add("action");
        eigenBt.setText("EIGEN");
        eigenBt.setFont(new Font(35.0));
        eigenBt.setOnAction(actionEvent -> {
            try {
                MenuController.showEigen(txtArea);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        anchorPane.getChildren().add(txtArea);
        anchorPane.getChildren().add(txtField);
        anchorPane.getChildren().add(generateBt);
        anchorPane.getChildren().add(backBt);
        anchorPane.getChildren().add(matricesBt);
        anchorPane.getChildren().add(solutionBt);
        anchorPane.getChildren().add(equationBt);
        anchorPane.getChildren().add(infoBt);
        anchorPane.getChildren().add(normalizedBt);
        anchorPane.getChildren().add(eigenBt);

    }




}
