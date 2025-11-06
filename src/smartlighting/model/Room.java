package smartlighting.model;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private final String name;
    private final List<Light> lights;
    
    public Room(String name) {
        this.name = name;
        this.lights = new ArrayList<>();
    }
    
    public void addLight(Light light) {
        lights.add(light);
    }
    
    public List<Light> getLights() { return lights; }
    public String getName() { return name; }
}