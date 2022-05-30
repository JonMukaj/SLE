package com.example.jonsle;

import com.example.jonsle.View.Home;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage)  {
        stage.setScene(new Home(stage).createHomeScene());
        stage.setResizable(false);
        stage.getIcons().add(new Image(App.class.getResourceAsStream("img/sigma.png")));
        stage.setTitle("SLE GENERATOR");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
