package smartlighting.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Light {
    private final BooleanProperty isOn;
    private final DoubleProperty brightness;
    private final String name;
    
    public Light(String name) {
        this.name = name;
        this.isOn = new SimpleBooleanProperty(false);
        this.brightness = new SimpleDoubleProperty(0.5); // Default 50% brightness
    }
    
    // Properties for binding
    public BooleanProperty isOnProperty() { return isOn; }
    public DoubleProperty brightnessProperty() { return brightness; }
    
    // Getters and setters
    public boolean isOn() { return isOn.get(); }
    public void setOn(boolean on) { isOn.set(on); }
    
    public double getBrightness() { return brightness.get(); }
    public void setBrightness(double brightness) { 
        this.brightness.set(Math.max(0, Math.min(1, brightness))); 
    }
    
    public String getName() { return name; }
}