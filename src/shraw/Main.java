package shraw;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main.
 */
public final class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Sh-raw");
        primaryStage.setScene(new Scene(root, 1021, 721));
        primaryStage.show();
    }

    /**
     * Entry point.
     *
     * @param args Аргументы командной строки
     */
    public static void main(String[] args) {
        launch(args);
    }
}
