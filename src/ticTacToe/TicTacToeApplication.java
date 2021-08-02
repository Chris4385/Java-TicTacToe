package ticTacToe;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
public class TicTacToeApplication extends Application{
//    private GameLogic game;
//    @Override
//    public void init() throws Exception{
//        this.game = new GameLogic();
//    }

    @Override
    public void start(Stage window) throws Exception{
        startGame(window);

    }

    private void restart (Stage window){
        window.close();
        startGame(window);
    }

    private void startGame(Stage window){
        GameLogic game = new GameLogic();
        Label description = new Label("Turn: X");
        BorderPane layout = new BorderPane();
        GridPane gameLayout = new GridPane();
        HBox heading = new HBox();
        HBox ending = new HBox();
        Button restart = new Button("Restart");

        //style restart button
        restart.setMinSize(60,15);
        restart.setStyle("-fx-font-size:20");
        restart.setVisible(false);

        // adjust heading and ending
        heading.getChildren().add(description);
        ending.getChildren().add(restart);
        ending.setAlignment(Pos.CENTER);
        heading.setAlignment(Pos.CENTER);
        heading.setPadding(new Insets(10,0,0,0));
        ending.setPrefHeight(60);
        layout.setTop(heading);
        layout.setBottom(ending);


        Button butt1 = new Button();
        Button butt2 = new Button();
        Button butt3 = new Button();
        Button butt4 = new Button();
        Button butt5 = new Button();
        Button butt6 = new Button();
        Button butt7 = new Button();
        Button butt8 = new Button();
        Button butt9 = new Button();

        gameLayout.setVgap(10);
        gameLayout.setHgap(10);
        gameLayout.setPadding(new Insets(10,10,10,10));
        gameLayout.setAlignment(Pos.CENTER);


        description.setFont(Font.font("Monospaced", 40));
        setButtonStyles(butt1);
        setButtonStyles(butt2);
        setButtonStyles(butt3);
        setButtonStyles(butt4);
        setButtonStyles(butt5);
        setButtonStyles(butt6);
        setButtonStyles(butt7);
        setButtonStyles(butt8);
        setButtonStyles(butt9);



        gameLayout.add(butt1, 0,0);
        gameLayout.add(butt2, 1,0);
        gameLayout.add(butt3, 2,0);
        gameLayout.add(butt4, 0,1);
        gameLayout.add(butt5, 1,1);
        gameLayout.add(butt6, 2,1);
        gameLayout.add(butt7, 0,2);
        gameLayout.add(butt8, 1,2);
        gameLayout.add(butt9, 2,2);

        restart.setOnAction((event) -> {
            restart(window);
        });
        butt1.setOnAction((event) ->{
            gamePlay(butt1, description,restart,game);
        });

        butt2.setOnAction((event) ->{
            gamePlay(butt2, description,restart,game);
        });

        butt3.setOnAction((event) ->{
            gamePlay(butt3, description,restart,game);
        });

        butt4.setOnAction((event) ->{
            gamePlay(butt4, description,restart,game);
        });

        butt5.setOnAction((event) ->{
            gamePlay(butt5, description, restart,game);
        });

        butt6.setOnAction((event) ->{
            gamePlay(butt6, description, restart,game);
        });

        butt7.setOnAction((event) ->{
            gamePlay(butt7, description, restart,game);
        });

        butt8.setOnAction((event) ->{
            gamePlay(butt8, description, restart,game);
        });

        butt9.setOnAction((event) ->{
            gamePlay(butt9, description, restart,game);
        });



        layout.setCenter(gameLayout);
        Scene scene = new Scene(layout, 400,400);
        window.setTitle("Classic Tic Tac Toe");
        window.setScene(scene);
        window.show();
    }


    private void setButtonStyles(Button butt){
        butt.setFont(Font.font("Monospaced", 40));
        butt.setMinSize(80,80);
    }

    private void gamePlay(Button butt, Label description, Button restart, GameLogic game){
        if(game.hasGameResult())
            return;
        int column = GridPane.getColumnIndex(butt);
        int row = GridPane.getRowIndex(butt);
        if(butt.getText().isEmpty()){
            butt.setText(game.currPlayerIdentity());
        }

        game.start(new Spot(row, column));
        if(game.hasGameResult()){
            description.setText("The end!");
            restart.setVisible(true);
        }else{
            description.setText("Turn: " + game.currPlayerIdentity());
        }
    }

    public static void main(String[] args) throws Exception {
        launch(TicTacToeApplication.class);
    }

}
