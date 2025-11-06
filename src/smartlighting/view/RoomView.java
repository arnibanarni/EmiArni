package smartlighting.view;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import smartlighting.model.Room;

public class RoomView {
    private final Room room;
    private VBox view;
    
    public RoomView(Room room) {
        this.room = room;
        createView();
    }
    
    private void createView() {
        // Room title
        Label title = new Label(room.getName());
        title.getStyleClass().add("room-title");
        
        view = new VBox(15);
        view.getStyleClass().add("room-view");
        view.getChildren().add(title);
        
        // Add light views for each light in the room
        room.getLights().forEach(light -> {
            LightView lightView = new LightView(light);
            view.getChildren().add(lightView.getView());
        });
    }
    
    public VBox getView() { return view; }
    public Room getRoom() { return room; }
}