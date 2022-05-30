package com.example.jonsle.Controller;

import java.awt.*;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MenuController {
    private MenuController() {}

    public static void returnHome(Scene oldScene, Stage stage) {
        stage.setScene(oldScene);
    }
    public static void showStatus(String numberOfUnknowns, TextArea textArea,int choice) {
        try {
            executeScript(numberOfUnknowns,choice);
            convertToPDF();
            textArea.setText("SLE GENERATED SUCCESSFULLY!");
        } catch (Exception e) {
            textArea.setText("Oops! Something went wrong. The matrix could not be generated. Try again!");
            textArea.setStyle("-fx-text-fill: #ff0000;");
            e.printStackTrace();
        }
    }

    private static void executeScript(String numberOfUnknowns,int choice) throws IOException, InterruptedException {
        String script = "";
        if(choice == 1)
             script = System.getProperty("user.dir") + "\\InverseMethod.py";
        else if(choice == 2) {
            script = System.getProperty("user.dir") + "\\LUMethod.py";
            System.out.println("LU executed");
        }

        ProcessBuilder executeScript = new ProcessBuilder(
                "python", "\"" + script + "\"", numberOfUnknowns);
        executeScript.start();
        TimeUnit.SECONDS.sleep(1);
    }

    private static void convertToPDF() throws IOException {
        String locationOfPdf = System.getProperty("user.dir") + "\\GeneratedSleMatrix.pdf";
        File pdf = new File(locationOfPdf);
        boolean status = pdf.exists();
        if (status) {
            pdf.delete();
        }

        String commandTex = "pdflatex";
        String locationOfTex = System.getProperty("user.dir") + "\\GeneratedSleMatrix.tex";
        ProcessBuilder convertToLatex = new ProcessBuilder(commandTex, "\"" + locationOfTex + "\"");

        File latex = new File(locationOfTex);
        boolean texExists = latex.exists();
        if (texExists) {
            convertToLatex.start();
        }
        System.out.println("Success!");
    }

    public static void openEquation() throws IOException, InterruptedException {
        String locationOfPdf = System.getProperty("user.dir") + "\\GeneratedSleMatrix.pdf";
        File pdf = new File(locationOfPdf);
        if (pdf.exists()) {
            Desktop.getDesktop().open(pdf);
            TimeUnit.SECONDS.sleep(1);
        }
    }


    public static void showSolution(TextArea textArea) throws IOException{
        String locationOfSolution = System.getProperty("user.dir") + "\\Solution.txt";
        File txtSol = new File(locationOfSolution);
        BufferedReader outputSolution = new BufferedReader(new FileReader(txtSol));

        String output, result = "";
        while ((output = outputSolution.readLine()) != null) {
            result += output + "\n";
        }
        //System.out.println(result);
        textArea.setText(result);
        outputSolution.close();
    }
    public static void showMatrices(TextArea textArea) throws IOException{
        String locationOfMatrices = System.getProperty("user.dir") + "\\Matrices.txt";
        File txtMatrix = new File(locationOfMatrices);
        BufferedReader outputMatrices = new BufferedReader(new FileReader(txtMatrix));

        String output, result = "";
        while ((output = outputMatrices.readLine()) != null) {
            result += output + "\n";
        }
        //System.out.println(result);
        textArea.setText(result);
        outputMatrices.close();
    }

    public static void showInfo(TextArea textArea) throws IOException{
        String locationOfInfo = System.getProperty("user.dir") + "\\Info.txt";
        File txtInfo = new File(locationOfInfo);
        BufferedReader outputInfo = new BufferedReader(new FileReader(txtInfo));

        String output, result = "";
        while ((output = outputInfo.readLine()) != null) {
            result += output + "\n";
        }
        //System.out.println(result);
        textArea.setText(result);
        outputInfo.close();
    }

    public static void showNormalized(TextArea textArea) throws IOException{
        String locationOfnormalized = System.getProperty("user.dir") + "\\Normalized.txt";
        File txtNormalized = new File(locationOfnormalized);
        BufferedReader outputNormalized = new BufferedReader(new FileReader(txtNormalized));

        String output, result = "";
        while ((output = outputNormalized.readLine()) != null) {
            result += output + "\n";
        }
        //System.out.println(result);
        textArea.setText(result);
        outputNormalized.close();
    }

    public static void showEigen(TextArea textArea) throws IOException{
        String locationOfEigen = System.getProperty("user.dir") + "\\Eigen.txt";
        File txtEigen = new File(locationOfEigen);
        BufferedReader outputEigen = new BufferedReader(new FileReader(txtEigen));

        String output, result = "";
        while ((output = outputEigen.readLine()) != null) {
            result += output + "\n";
        }
        //System.out.println(result);
        textArea.setText(result);
        outputEigen.close();
    }

}
