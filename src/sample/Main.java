package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Main extends Application {
    public Pane pane;
    Controller controller;
    Model model;
    public final int PANE_DEFAULT_WIDTH = 260;
    public final int PANE_DEFAULT_HEIGHT = 420;
    private int rec_side_length;
    @Override
    public void start(Stage primaryStage) throws Exception{

        model = new Model();
        model.setView(this);
        rec_side_length = PANE_DEFAULT_WIDTH/model.DEFAULT_BOARD_WIDTH -1;
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        Rectangle Rec = new Rectangle(10,10,10,10);
        Rec.setFill(Color.RED);
        pane = new Pane();
        pane.setPrefWidth(PANE_DEFAULT_WIDTH);
        pane.setPrefHeight(PANE_DEFAULT_HEIGHT);
        pane.getChildren().add(Rec);

        StackPane FatherPane = new StackPane();
        Pane listenerPane = new Pane();
        FatherPane.getChildren().add(pane);
        FatherPane.getChildren().add(listenerPane);

        pane.getChildren().add(new Button());
        listenerPane.requestFocus();
        Rec.setOnKeyPressed(e->{
            if(e.getCode() == KeyCode.A){
            System.out.println("3");
            this.notifyModel();}
        });

        Scene scene = new Scene(FatherPane, 350, 420);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public void notifyModel(){
        pane.getChildren().add(new Rectangle(50,50,50,50));
        pane.getChildren().add(new Rectangle(100,100,rec_side_length,rec_side_length));

    }


    public static void main(String[] args) {
        launch(args);
    }
}
