module gg.projects.videogamerandomizer {
    requires javafx.controls;
    requires javafx.fxml;


    opens videogamerandomizer to javafx.fxml;
    opens videogamerandomizer.GUI to javafx.fxml;
    exports videogamerandomizer;
    exports videogamerandomizer.GUI;

}