package cr.ac.una.tutoria2.controller;

import cr.ac.una.tutoria2.util.Mensaje;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author USUARIO PZ UNA
 */
public class LogInViewController extends Controller implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private TextField txtUsurio;
    @FXML
    private TextField txtContrasena;
    @FXML
    private Button btnIngresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void initialize() {
    }

    @FXML
    private void onActionBtnIngresar(ActionEvent event) {
        if (txtUsurio.getText().isBlank()){
            new Mensaje().show(Alert.AlertType.INFORMATION, "Inicio Sesion", "campo de texto usuario");
        }
    }
    
}
