package com.example.jonsle.Controller;

import com.example.jonsle.View.InverseMenu;
import com.example.jonsle.View.LuMenu;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeController {

    private HomeController() {

    }
    public static void createInverseMenu(Stage stage) {
        Scene oldScene = stage.getScene();
        stage.setScene(new InverseMenu(stage,oldScene).createInverseMenu());
    }

    public static void createLuMenu(Stage stage) {
        Scene oldScene = stage.getScene();
        stage.setScene(new LuMenu(stage,oldScene).createLuMenu());
    }


}
