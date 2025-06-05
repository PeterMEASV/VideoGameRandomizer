module gg.projects.videogamerandomizer {
    requires javafx.controls;
    requires javafx.fxml;

    opens videogamerandomizer to javafx.fxml;
    opens videogamerandomizer.GUI.controllers to javafx.fxml;
    opens videogamerandomizer.GUI.util to javafx.fxml;

    exports videogamerandomizer;
    exports videogamerandomizer.GUI.controllers;
    exports videogamerandomizer.GUI.util;
}