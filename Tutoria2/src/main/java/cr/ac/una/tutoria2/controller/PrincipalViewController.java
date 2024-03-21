
package cr.ac.una.tutoria2.controller;

import cr.ac.una.tutoria2.model.Usuario;
import cr.ac.una.tutoria2.util.AppContext;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author USUARIO PZ UNA
 */
public class PrincipalViewController extends Controller implements Initializable {

    @FXML
    private Label lblUserName;
    @FXML
    private Button btnMantUsuarios;
    @FXML
    private Button btnCerrarSesion;
    @FXML
    private Button btnSalir;
    
    Usuario user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        user = (Usuario) AppContext.getInstance().get("USUARIO");
        
        lblUserName.setText(user.getNombreCompleto());
    }    

    @Override
    public void initialize() {}

    @FXML
    private void onActionBtnMantUsuarios(ActionEvent event) {
    }

    @FXML
    private void onActionBtnCerrarSesion(ActionEvent event) {
    }

    @FXML
    private void onActionBtnSalir(ActionEvent event) {
    }
    
}
