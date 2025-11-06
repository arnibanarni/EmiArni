package smartlighting.view;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import smartlighting.Controller;

public class DashboardLayout {
    private final Controller controller;
    private BorderPane root;
    private TilePane roomsPane;
    
    public DashboardLayout(Controller controller) {
        this.controller = controller;
    }
    
    public BorderPane createLayout() {
        root = new BorderPane();
        root.getStyleClass().add("dashboard");
        
        // Header
        HBox header = createHeader();
        root.setTop(header);
        
        // Main content - rooms
        roomsPane = new TilePane();
        roomsPane.getStyleClass().add("rooms-pane");
        roomsPane.setPrefColumns(3);
        roomsPane.setHgap(20);
        roomsPane.setVgap(20);
        roomsPane.setPadding(new javafx.geometry.Insets(20));
        
        // Add room views
        controller.getRooms().forEach(room -> {
            RoomView roomView = new RoomView(room);
            roomsPane.getChildren().add(roomView.getView());
        });
        
        root.setCenter(roomsPane);
        
        return root;
    }
    
    private HBox createHeader() {
        HBox header = new HBox(20);
        header.getStyleClass().add("header");
        header.setPadding(new javafx.geometry.Insets(15));
        header.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        
        Text title = new Text("Smart Lighting Simulator");
        title.getStyleClass().add("title");
        
        ToggleButton nightModeToggle = new ToggleButton("Night Mode");
        nightModeToggle.selectedProperty().bindBidirectional(controller.nightModeProperty());
        
        header.getChildren().addAll(title, nightModeToggle);
        
        return header;
    }
}