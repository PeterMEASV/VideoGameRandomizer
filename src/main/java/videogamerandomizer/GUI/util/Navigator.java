package videogamerandomizer.GUI.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Navigator {
private static Navigator instance;
private BorderPane root;
private Object currentController;

private Navigator()
{
}

    public static Navigator getInstance()
    {
        if(instance == null)
        {
            instance = new Navigator();
        }
        return instance;
    }

    public void initRoot(BorderPane root)
    {
        this.root = root;
    }

    public void navigateTo(Views path)
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path.getPath()));
        try
        {
            root.setCenter(loader.load());
            currentController = loader.getController();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
