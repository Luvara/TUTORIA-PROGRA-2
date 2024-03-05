package cr.ac.una.tutoria2;

import cr.ac.una.tutoria2.util.FlowController;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import static javafx.application.Application.launch;

/**
 * JavaFX App
 */
public class App extends Application {

   @Override
    public void start(Stage stage) throws IOException {
        FlowController.getInstance().InitializeFlow(stage, null);
//        stage.getIcons().add(new Image(App.class.getResourceAsStream("/cr/ac/una/tutoria2ejemplo/resources/icons/userIcon.png")));
        stage.setTitle("Tutoria 2");
        
        FlowController.getInstance().goViewInWindow("logInView");
    }

    public static void main(String[] args) {
        launch();
    }

}