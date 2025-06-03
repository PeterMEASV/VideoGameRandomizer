module gg.projects.videogamerandomizer {
    requires javafx.controls;
    requires javafx.fxml;


    opens gg.projects.videogamerandomizer to javafx.fxml;
    exports gg.projects.videogamerandomizer;
}