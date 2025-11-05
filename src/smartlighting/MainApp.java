package smartlighting;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label("JavaFX fungerer! 🔥");
        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 400, 200);
        stage.setScene(scene);
        stage.setTitle("JavaFX Test");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
