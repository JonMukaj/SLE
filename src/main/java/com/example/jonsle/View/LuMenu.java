package com.example.jonsle.View;

import com.example.jonsle.Controller.MenuController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LuMenu extends Menu{
    public LuMenu(Stage stage,Scene old) {
        super(stage,old);
        anchorPane.getStyleClass().add("lu");
        anchorPane.getStylesheets().add(this.getClass().getResource("/style.css").toExternalForm());
        generateBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String numberOfUnknowns = txtField.getText();
                System.out.println(numberOfUnknowns);
                MenuController.showStatus(numberOfUnknowns,txtArea,2);
            }
        });


    }
    public Scene createLuMenu () {
        Scene scene = new Scene(anchorPane, 1000, 700);
        return scene;
    }
}
