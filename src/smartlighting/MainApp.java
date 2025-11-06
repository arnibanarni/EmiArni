package smartlighting;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import smartlighting.view.DashboardLayout;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Controller controller = new Controller();
        DashboardLayout dashboard = new DashboardLayout(controller);

        Scene scene = new Scene(dashboard.createLayout(), 800, 600);
        
        // CSS styling - bruk try-catch for å håndtere hvis CSS fil ikke finnes
        try {
            scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        } catch (Exception e) {
            System.out.println("CSS fil ikke funnet, appen kjører uten styling");
        }
        
        primaryStage.setTitle("Smart Lighting Simulator");
        primaryStage.setScene(scene);
        primaryStage.show(); // <-- DENNE MANGLE!
    }

    public static void main(String[] args) {
        launch(args);
    }
}