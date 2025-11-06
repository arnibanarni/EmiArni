package smartlighting;

import javafx.beans.property.BooleanProperty;
import smartlighting.model.LightingSystem;
import smartlighting.model.Room;
import java.util.List;

public class Controller {
    private final LightingSystem lightingSystem;
    
    public Controller() {
        this.lightingSystem = new LightingSystem();
    }
    
    public List<Room> getRooms() {
        return lightingSystem.getRooms();
    }
    
    public BooleanProperty nightModeProperty() {
        return lightingSystem.nightModeProperty();
    }
}