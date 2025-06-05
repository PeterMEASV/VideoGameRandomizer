package videogamerandomizer.GUI.controllers;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import videogamerandomizer.GUI.util.Navigator;
import videogamerandomizer.GUI.util.Views;

import java.net.URL;
import java.util.ResourceBundle;

public class SelectionPageController implements Initializable {

    private boolean isSidebarVisible = true;
    @FXML
    private Button btnMenu;
    @FXML
    private VBox sidebar;
    @FXML
    private BorderPane rootPane;
    
    private double sidebarWidth;
    @FXML
    private ComboBox comboFavorites;
    @FXML
    private Button btnLibrary;
    @FXML
    private Button btnSettings;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Bind sidebar width to 30% of root pane width
        sidebar.prefWidthProperty().bind(rootPane.widthProperty().multiply(0.3));
        sidebar.setTranslateX(0);
        
        // Store the initial sidebar width for later use
        sidebar.widthProperty().addListener((obs, oldVal, newVal) -> {
            sidebarWidth = newVal.doubleValue();
        });

        btnMenu.setOnAction(event -> toggleSidebar());

        Navigator.getInstance().initRoot(rootPane);
    }

    private void toggleSidebar() {
        // Unbind before doing anything
        sidebar.prefWidthProperty().unbind();

        double fromWidth = sidebar.getWidth();
        double toWidth;

        if (isSidebarVisible) {
            // Collapse sidebar to only show menu button
            toWidth = 86;
        } else {
            // Expand sidebar back to 30% of root width
            toWidth = rootPane.getWidth() * 0.3;
            btnLibrary.setVisible(true);
            btnSettings.setVisible(true);
            comboFavorites.setVisible(true);

            btnLibrary.setManaged(true);
            btnSettings.setManaged(true);
            comboFavorites.setManaged(true);
        }

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(sidebar.prefWidthProperty(), fromWidth)),
                new KeyFrame(Duration.millis(300), new KeyValue(sidebar.prefWidthProperty(), toWidth))
        );

        timeline.setOnFinished(e -> {
            isSidebarVisible = !isSidebarVisible; // flip AFTER animation

            if (isSidebarVisible) {
                // Only re-bind after expanding
                sidebar.prefWidthProperty().bind(rootPane.widthProperty().multiply(0.3));
            }
            else
            {
                btnLibrary.setVisible(false);
                btnSettings.setVisible(false);
                comboFavorites.setVisible(false);

                btnLibrary.setManaged(false);
                btnSettings.setManaged(false);
                comboFavorites.setManaged(false);
            }
        });

        timeline.play();
    }







    @FXML
    private void handleGameLibrary(ActionEvent actionEvent) {
        Navigator.getInstance().navigateTo(Views.GAME_LIBRARY_VIEW);

        // After loading new content, adjust its position if sidebar is hidden
        if (!isSidebarVisible && rootPane.getCenter() != null) {
            Region centerContent = (Region) rootPane.getCenter();
            centerContent.setTranslateX(-sidebarWidth + 86);
        }
    }
}