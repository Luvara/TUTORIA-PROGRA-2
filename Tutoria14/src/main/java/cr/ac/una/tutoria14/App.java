package cr.ac.una.tutoria14;

import cr.ac.una.tutoria14.util.FlowController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FlowController.getInstance().InitializeFlow(stage, null);
        //stage.getIcons().add(new Image(""));
        stage.setTitle("Tutoria14");
        FlowController.getInstance().goViewInWindow("pruebaView");
    }

    public static void main(String[] args) {
        launch();
    }

}