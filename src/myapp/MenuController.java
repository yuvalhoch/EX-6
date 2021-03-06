package myapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * MenuController.
 * runs all actions from Menu FXML
 */
public class MenuController {

    @FXML
    private Button btnStart;

    @FXML
    private Button btnSetting;


    /**
     * btnStartClick func.
     * handels event of start game button click
     */
    @FXML
    protected void startBtnClicked() {
        try {
            /*Stage stage = (Stage) btnStart.getScene().getWindow();
            GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("FXMLBoard.fxml")); //doesnt exists yet !! just to remember
            Scene scene = new Scene(root, 400, 350); //random sizes
            stage.setTitle("Reversi Game");
            stage.setScene(scene);
            stage.show();*/
            Stage stage = (Stage) btnStart.getScene().getWindow();
            HBox root = (HBox)FXMLLoader.load(getClass().getResource("FXMLGame.fxml"));
            Scene scene = new Scene(root,400,350);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.setTitle("Reversi game");
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {

        }
    }

    /**
     * btnSettings func.
     * handels event of settings button click
     */
    @FXML
    protected void settingsBtnClicked() {
        try {

            Stage stage = (Stage)btnSetting.getScene().getWindow();
            GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("FXMLSettings.fxml"));
            Scene scene = new Scene(root, 400, 350);
            stage.setTitle("Reversi");
            stage.setScene(scene);
            stage.show();
        }catch (Exception ex) {

        }

    }

}