import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My First App");
        Label lbl = new Label("Hello World!");
        lbl.setFont(new Font("Arial", 300));
        StackPane root = new StackPane();
        root.getChildren().add(lbl);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
