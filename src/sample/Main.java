package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Main extends Application {
    public GridPane pane;
    Pane paintPane;
    Controller controller;
    Model model;
    public final int PANE_DEFAULT_WIDTH = 260;
    public final int PANE_DEFAULT_HEIGHT = 420;
    private int rec_side_length;
    @Override
    public void start(Stage primaryStage) throws Exception{

        model = new Model();
        model.setView(this);
        controller = new Controller();
        controller.setModel(model);
        controller.setView(this);

        rec_side_length = PANE_DEFAULT_WIDTH/model.DEFAULT_BOARD_WIDTH -1;
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        //Rectangle Rec = new Rectangle(10,10,10,10);
        //Rec.setFill(Color.RED);
        pane = new GridPane();
        paintPane = new Pane();
        paintPane.setPrefWidth(PANE_DEFAULT_WIDTH);
        paintPane.setPrefHeight(PANE_DEFAULT_HEIGHT);
        //pane.getChildren().add(Rec);


        pane.add(paintPane, 0,0);

//        pane.getChildren().add(new Button());
        VBox vb = new VBox();
        Button startButton = new Button("Start");
        Button endButton = new Button("end");
        startButton.setOnAction(event -> {
            controller.initGame();
        });
        endButton.setOnAction(event -> {
            controller.end();
        });
        vb.getChildren().add(startButton);
        vb.getChildren().add(endButton);
        pane.add(vb,1,0);

        pane.setOnKeyPressed(e->{
            if(e.getCode() == KeyCode.A){
            System.out.println("3");
            this.notifyView();}
        });

        Scene scene = new Scene(pane, 350, 420);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public void notifyView(){
        paintPane.getChildren().clear();
        paintPane.getChildren().add(new Rectangle(50,50,50,50));
        paintPane.getChildren().add(new Rectangle(100,100,rec_side_length,rec_side_length));
        model.getBoard();
        model.getBoard()[0][0].getColor();

        for(int indexa = 0; indexa < model.DEFAULT_BOARD_HEIGHT; indexa++){
            for(int indexb = 0; indexb < model.DEFAULT_BOARD_WIDTH; indexb++){
                if(model.getBoard()[indexa][indexb].getColor() != Block.blockColor.NONE)
                {
                    Rectangle rec = new Rectangle(indexb*(rec_side_length+1), indexa*(rec_side_length+1),
                            rec_side_length,rec_side_length);
                    switch (model.getBoard()[indexa][indexb].getColor()){
                        case blue: rec.setFill(Color.BLUE); break;
                        case red: rec.setFill(Color.RED); break;
                        case yellow: rec.setFill(Color.YELLOW); break;
                        default: rec.setFill(Color.BLACK);
                    }
                    paintPane.getChildren().add(rec);
                }
            }
        }
//        paintPane.getChildren().add(new Rectangle())
    }


    public static void main(String[] args) {
        launch(args);
    }
}
