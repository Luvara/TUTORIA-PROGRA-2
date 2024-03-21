package cr.ac.una.tutoria2.controller;

import cr.ac.una.tutoria2.model.Usuario;
import cr.ac.una.tutoria2.util.AppContext;
import cr.ac.una.tutoria2.util.FlowController;
import cr.ac.una.tutoria2.util.Mensaje;
import cr.ac.una.tutoria2.util.Utilidades;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
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

    Usuario user;
    Image image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Tooltip tooltip = new Tooltip("Selecionar imagen");
        tooltip.setStyle("-fx-font-size: 16px;");
        Tooltip.install(imgUserIcon, tooltip);
        
        user = new Usuario("Luis", "Vargas", "Araya", "115680957", LocalDate.of(1994, 4, 29), Usuario.Sexo.MASCULINO, Usuario.EnumEstCivil.VIUDO, "luvara", "qwerty", image);       
        
        imgUserIcon.setOnMouseClicked(event ->{
            new Mensaje().show(Alert.AlertType.INFORMATION, "Click Imagen", "Hola esto es un click a una imagen");
           // image = Utilidades.cargarImagenLocal(imgUserIcon);
        });
    }    

    @Override
    public void initialize() { 
    
    }

    @FXML
    private void onActionBtnCancelar(ActionEvent event) {
        
    }

    @FXML
    private void onActionBtnIngresar(ActionEvent event) {
        if (txtUsuario.getText().isBlank()){
            new Mensaje().show(Alert.AlertType.WARNING, "Inicio Sesion", "Campo de usuario vacio");
        } else if (txtContrasena.getText().isBlank()){
            new Mensaje().show(Alert.AlertType.WARNING, "Inicio Sesion", "Campo de contraseña vacio");
        } else {
            if (txtUsuario.getText().equals(user.getUsuario()) && txtContrasena.getText().equals(user.getContrasena())){
                //TODO
                AppContext.getInstance().set("USUARIO", user);
                FlowController.getInstance().goMain();
                getStage().close();
            } else {
                System.out.println("Error");
            }
        }
    }

    @FXML
    private void onActionBtnAcercaDe(ActionEvent event) {
        
    }
    
}
