package cr.ac.una.tutoria2.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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
    private ImageView imgUserIcon;
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtContrasena;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnIngresar;
    @FXML
    private Button btnAcercaDe;


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
    private void onActionBtnCancelar(ActionEvent event) {
        
    }

    @FXML
    private void onActionBtnIngresar(ActionEvent event) {
        
    }

    @FXML
    private void onActionBtnAcercaDe(ActionEvent event) {
        
    }
    
}
