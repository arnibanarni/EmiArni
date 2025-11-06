package smartlighting.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import smartlighting.model.Light;

public class LightView {
    private final Light light;
    private VBox view;
    private Circle lightVisual;
    private Label brightnessLabel;
    
    public LightView(Light light) {
        this.light = light;
        createView();
        setupBindings();
    }
    
    private void createView() {
        // Light visualization
        lightVisual = new Circle(30);
        lightVisual.setStroke(Color.DARKGRAY);
        lightVisual.setFill(Color.GRAY);
        
        // Light name
        Label nameLabel = new Label(light.getName());
        nameLabel.getStyleClass().add("light-name");
        
        // On/Off button
        Button toggleButton = new Button("OFF");
        toggleButton.getStyleClass().add("toggle-button");
        
        // Brightness slider
        Slider brightnessSlider = new Slider(0, 1, 0.5);
        brightnessSlider.setShowTickLabels(true);
        brightnessSlider.setShowTickMarks(true);
        brightnessSlider.setMajorTickUnit(0.5);
        brightnessSlider.setBlockIncrement(0.1);
        
        brightnessLabel = new Label("50%");
        brightnessLabel.getStyleClass().add("brightness-label");
        
        // Layout
        view = new VBox(10, lightVisual, nameLabel, toggleButton, brightnessSlider, brightnessLabel);
        view.setAlignment(Pos.CENTER);
        view.setPadding(new Insets(15));
        view.getStyleClass().add("light-view");
        
        // Event handlers
        toggleButton.setOnAction(e -> {
            light.setOn(!light.isOn());
            updateToggleButton(toggleButton);
        });
        
        brightnessSlider.valueProperty().bindBidirectional(light.brightnessProperty());
    }
    
    private void setupBindings() {
        // Bind light appearance to properties
        lightVisual.fillProperty().bind(
            javafx.beans.binding.Bindings.when(light.isOnProperty())
                .then(
                    javafx.beans.binding.Bindings.createObjectBinding(() -> 
                        Color.hsb(50, 0.3, light.getBrightness()), // Warm yellow color
                        light.brightnessProperty()
                    )
                )
                .otherwise(Color.GRAY)
        );
        
        // Update brightness label
        light.brightnessProperty().addListener((obs, oldVal, newVal) -> {
            brightnessLabel.setText(String.format("%d%%", (int)(newVal.doubleValue() * 100)));
        });
    }
    
    private void updateToggleButton(Button button) {
        if (light.isOn()) {
            button.setText("ON");
            button.getStyleClass().remove("off");
            button.getStyleClass().add("on");
        } else {
            button.setText("OFF");
            button.getStyleClass().remove("on");
            button.getStyleClass().add("off");
        }
    }
    
    public VBox getView() { return view; }
    public Light getLight() { return light; }
}