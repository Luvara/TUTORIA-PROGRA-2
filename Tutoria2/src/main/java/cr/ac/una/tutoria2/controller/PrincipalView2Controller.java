package cr.ac.una.tutoria2.controller;

import cr.ac.una.tutoria2.model.Usuario;
import cr.ac.una.tutoria2.util.AppContext;
import cr.ac.una.tutoria2.util.FlowController;
import cr.ac.una.tutoria2.util.Mensaje;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Luvara
 */
public class PrincipalView2Controller extends Controller implements Initializable {

    @FXML
    private Label lblUserName;
    @FXML
    private ImageView imgIconUser;
    @FXML
    private Label lblAppName;
    @FXML
    private VBox vboxButtons;
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

        lblUserName.setText("Bienvenido: " + user.getNombreCompleto());

//        isAdmin();
    }

    @Override
    public void initialize() {
       
    }

    @FXML
    private void onActionBtnCerrarSesion(ActionEvent event) {
//        FlowController.getInstance().goViewInWindow("logInView");
//        FlowController.getInstance().salir();
    }

    @FXML
    private void onActionBtnSalir(ActionEvent event) {
//        FlowController.getInstance().salir();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//        user = (Usuario) AppContext.getInstance().get("USUARIO");
//
//        lblUserName.setText("Bienvenido: " + user.getNombreCompleto());
//
//        isAdmin();
//    }
//
//    @Override
//    public void initialize() {
//        isAdmin();
//    }

//    private void isAdmin() {
//        if (user.getIsAdmin()) {
//            crearBotonesAdmin();
//        } else {
//            crearBotonesUsuario();
//        }
//    }
//
//    private void crearBotonesAdmin() {
//        Button btnMantGeneral = new Button("Mantenimiento Generales");
//        btnMantGeneral.getStyleClass().add("btnMenu");
//        btnMantGeneral.setOnAction(event -> {
//            //new Mensaje().showModal(Alert.AlertType.INFORMATION, "Click", stage, "Se mostraria la pantalla de mantenimiento general");
//            
//            FlowController.getInstance().goView("MantenimientoGeneralesView");
//        });
//
//        Button btnMantUsuarios = new Button("Mantenimiento Usuarios");
//        btnMantUsuarios.getStyleClass().add("btnMenu");
//        btnMantUsuarios.setOnAction(event -> {
//            new Mensaje().showModal(Alert.AlertType.INFORMATION, "Click", stage, "Se mostraria la pantalla de mantenimiento de usuarios");
//        });
//
//        Button btnMantReportes = new Button("Reportes");
//        btnMantReportes.getStyleClass().add("btnMenu");
//        btnMantReportes.setOnAction(event -> {
//            new Mensaje().showModal(Alert.AlertType.INFORMATION, "Click", stage, "Se mostraria la pantalla de reportes");
//        });
//
//        vboxButtons.getChildren().clear();
//        vboxButtons.getChildren().addAll(btnMantGeneral, btnMantUsuarios, btnMantReportes);
//        vboxButtons.getStyleClass().add("vbox-principal-view");
//    }
//
//    private void crearBotonesUsuario() {
//        Button btnListaUsuario = new Button("Lista Usuarios");
//        btnListaUsuario.getStyleClass().add("btnMenu");
//        btnListaUsuario.setOnAction(event -> {
//            new Mensaje().showModal(Alert.AlertType.INFORMATION, "Click", stage, "Se mostraria la pantalla de Lista de Usuarios");
//        });
//
//        Button btnBuscarUsuario = new Button("Buscar Usuario");
//        btnBuscarUsuario.getStyleClass().add("btnMenu");
//        btnBuscarUsuario.setOnAction(event -> {
//            new Mensaje().showModal(Alert.AlertType.INFORMATION, "Click", stage, "Se mostraria la pantalla de buscar usuarios");
//        });
//
//        Button btnImprimirUsuario = new Button("Imprimir Usuario");
//        btnImprimirUsuario.getStyleClass().add("btnMenu");
//        btnImprimirUsuario.setOnAction(event -> {
//            new Mensaje().showModal(Alert.AlertType.INFORMATION, "Click", stage, "Se mostraria la pantalla de impriprir un usuario");
//        });
//
//        vboxButtons.getChildren().clear();
//        vboxButtons.getChildren().addAll(btnListaUsuario, btnBuscarUsuario, btnImprimirUsuario);
//        vboxButtons.getStyleClass().add("vbox-principal-view");
//    }

}
