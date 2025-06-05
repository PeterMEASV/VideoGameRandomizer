package videogamerandomizer.GUI.util;

public enum Views {

    GAME_LIBRARY_VIEW("/videogamerandomizer/Views/GameLibraryView.fxml");

    private final String path;
    Views(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
