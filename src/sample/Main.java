package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("My First App");
        Label lbl = new Label("Hello World!");
        lbl.setFont(new Font("Arial", 30));
        Button btn = new Button("Click me");
        btn.setOnAction(event -> {
            lbl.setText("Button clicked!");
        });
        VBox root = new VBox();
        root.getChildren().add(lbl);
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        GeneralPlayer player1, player2;
        Visualization screen = new Console();
        int choice, sign;
        //screen->openScreen();
        //cin >> choice;
        //create two players
        player1 = new HumanP('X');
        player2 = new HumanP('O');
        //creates new game
        GameFlow game = new GameFlow(player1, player2, screen);
        //runs the game
        game.run();
        launch(args);
    }
}
