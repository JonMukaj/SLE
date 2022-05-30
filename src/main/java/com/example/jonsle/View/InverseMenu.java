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

public class InverseMenu extends Menu {

    public InverseMenu(Stage stage,Scene old) {
        super(stage,old);
        anchorPane.getStyleClass().add("inv");
        anchorPane.getStylesheets().add(this.getClass().getResource("/style.css").toExternalForm());
        generateBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String numberOfUnknowns = txtField.getText();
                //System.out.println(numberOfUnknowns);
                MenuController.showStatus(numberOfUnknowns,txtArea,1);
            }
        });

    }
    public Scene createInverseMenu () {
        Scene scene = new Scene(anchorPane, 1000, 700);
        return scene;
    }

}
