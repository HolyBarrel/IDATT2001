package edu.ntnu.idatt2001.magnulal;

import edu.ntnu.idatt2001.magnulal.utils.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class that inherits from Application
 * The class has a start-method that shows the given stage
 * @author magnulal
 * @version 0.3
 * @since 0.3
*/
public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try{
            FXMLLoader fxmlLoader = SceneManager.retrieveLoader("main");
            SceneManager.setActiveScene(new Scene(fxmlLoader.load()));
            stage.setTitle("Wargames");
            stage.setScene(SceneManager.getActiveScene());
            stage.setMinHeight(540);
            stage.setMinWidth(720);
            stage.show();
        }catch (IOException i){
            i.printStackTrace();
        }
    }
    /**
     * Static void main-method to launch the Application
     * @param args, list of arguments for the static void method
    */
    public static void main(String[] args) {
        launch();
    }

}
