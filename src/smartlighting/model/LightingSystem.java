package smartlighting.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import java.util.ArrayList;
import java.util.List;

public class LightingSystem {
    private final List<Room> rooms;
    private final BooleanProperty nightMode;
    
    public LightingSystem() {
        this.rooms = new ArrayList<>();
        this.nightMode = new SimpleBooleanProperty(false);
        initializeRooms();
    }
    
    private void initializeRooms() {
        // Create rooms with lights
        Room livingRoom = new Room("Living Room");
        livingRoom.addLight(new Light("Main Light"));
        livingRoom.addLight(new Light("Lamp"));
        
        Room kitchen = new Room("Kitchen");
        kitchen.addLight(new Light("Ceiling Light"));
        
        Room bedroom = new Room("Bedroom");
        bedroom.addLight(new Light("Bedside Lamp"));
        bedroom.addLight(new Light("Main Light"));
        
        rooms.add(livingRoom);
        rooms.add(kitchen);
        rooms.add(bedroom);
    }
    
    public List<Room> getRooms() { return rooms; }
    public BooleanProperty nightModeProperty() { return nightMode; }
    public boolean isNightMode() { return nightMode.get(); }
    public void setNightMode(boolean nightMode) { this.nightMode.set(nightMode); }
}