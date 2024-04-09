package cr.ac.una.tutoria2.controller;

import cr.ac.una.tutoria2.model.Usuario;
import cr.ac.una.tutoria2.util.AppContext;
import cr.ac.una.tutoria2.util.FlowController;
import cr.ac.una.tutoria2.util.Mensaje;
import cr.ac.una.tutoria2.util.Utilidades;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    List<Usuario> listaUsuarios = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Tooltip tooltip = new Tooltip("Selecionar imagen");
        tooltip.setStyle("-fx-font-size: 16px;");
        Tooltip.install(imgUserIcon, tooltip);

        image = new Image("/cr/ac/una/tutoria2/resources/icons/userIconOp.png");
        imgUserIcon.setImage(image);
        listaUsuarios = crearListaUsuarios();

        //user = new Usuario("Luis", "Vargas", "Araya", "115680957", LocalDate.of(1994, 4, 29), Usuario.Sexo.MASCULINO, Usuario.EnumEstCivil.VIUDO, "luvara", "qwerty", true, null);
        imgUserIcon.setOnMouseClicked(event -> {
            new Mensaje().show(Alert.AlertType.INFORMATION, "Click Imagen", "Hola esto es un click a una imagen");
            // image = Utilidades.cargarImagenLocal(imgUserIcon);
        });
    }

    @Override
    public void initialize() {

    }

    @FXML
    private void onActionBtnCancelar(ActionEvent event) {
        getStage().close();
    }

    @FXML
    private void onActionBtnIngresar(ActionEvent event) {
        if (txtUsuario.getText().isBlank()) {
            new Mensaje().show(Alert.AlertType.WARNING, "Inicio Sesion", "Campo de usuario vacio");
        } else if (txtContrasena.getText().isBlank()) {
            new Mensaje().show(Alert.AlertType.WARNING, "Inicio Sesion", "Campo de contraseña vacio");
        } else {
            if (comprobarCredenciales(txtUsuario.getText(), txtContrasena.getText())) {
                AppContext.getInstance().set("USUARIO", user);
                AppContext.getInstance().set("LISTAUSUARIOS", listaUsuarios);
                AppContext.getInstance().set("APPICON", image);
                FlowController.getInstance().goMain();
                getStage().close();
            } else {
                System.out.println("Error");
                new Mensaje().show(Alert.AlertType.ERROR, "Inicio Sesion", "Credenciales invalidas");
            }
        }
    }

    @FXML
    private void onActionBtnAcercaDe(ActionEvent event) {

    }

    private Boolean comprobarCredenciales(String txtUser, String txtPass) {

        for (Usuario listaIterador : listaUsuarios) {
            if (listaIterador.getUsuario().equals(txtUser) && listaIterador.getContrasena().equals(txtPass)) {
                user = listaIterador;
                return true;
            }
        }
        return false;
    }

    private List<Usuario> crearListaUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        usuarios.add(new Usuario("Luis", "Vargas", "Araya", "115680957", LocalDate.of(1994, 4, 29), Usuario.Sexo.MASCULINO, Usuario.EnumEstCivil.VIUDO, "luvara", "qwerty", true, null));
        usuarios.add(new Usuario("María", "García", "López", "215680958", LocalDate.of(1990, 6, 15), Usuario.Sexo.FEMENINO, Usuario.EnumEstCivil.CASADO, "margarcia", "password", false, null));
        usuarios.add(new Usuario("Ana", "Martínez", "Díaz", "315680959", LocalDate.of(1985, 8, 10), Usuario.Sexo.FEMENINO, Usuario.EnumEstCivil.SOLTERO, "anamart", "contraseña", true, null));
        usuarios.add(new Usuario("Pedro", "Sánchez", "Ramírez", "415680960", LocalDate.of(1982, 3, 25), Usuario.Sexo.MASCULINO, Usuario.EnumEstCivil.DIVORCIADO, "psanchez", "123456", false, null));
        usuarios.add(new Usuario("Lucía", "López", "Hernández", "515680961", LocalDate.of(1978, 11, 17), Usuario.Sexo.FEMENINO, Usuario.EnumEstCivil.UNION_LIBRE, "lulopez", "abc123", false, null));
        usuarios.add(new Usuario("Juan", "Gómez", "Pérez", "615680962", LocalDate.of(1999, 9, 3), Usuario.Sexo.MASCULINO, Usuario.EnumEstCivil.SOLTERO, "juangomez", "securepass", true, null));
        usuarios.add(new Usuario("Laura", "Rodríguez", "González", "715680963", LocalDate.of(1987, 5, 8), Usuario.Sexo.FEMENINO, Usuario.EnumEstCivil.CASADO, "larodriguez", "password123", true, null));
        usuarios.add(new Usuario("Diego", "Herrera", "Fernández", "815680964", LocalDate.of(1975, 12, 21), Usuario.Sexo.MASCULINO, Usuario.EnumEstCivil.VIUDO, "diegoherrera", "mypassword", false, null));
        usuarios.add(new Usuario("Sofía", "Díaz", "Alvarez", "915680965", LocalDate.of(1989, 2, 14), Usuario.Sexo.FEMENINO, Usuario.EnumEstCivil.DIVORCIADO, "sofiadiaz", "sofipass", true, null));
        usuarios.add(new Usuario("Carlos", "Martín", "Morales", "1015680966", LocalDate.of(1983, 7, 6), Usuario.Sexo.MASCULINO, Usuario.EnumEstCivil.SOLTERO, "carlosmartin", "carlitos", false, null));
        usuarios.add(new Usuario("Elena", "Ruiz", "Iglesias", "1115680967", LocalDate.of(1996, 1, 30), Usuario.Sexo.FEMENINO, Usuario.EnumEstCivil.CASADO, "elenaRuiz", "elena123", true, null));
        usuarios.add(new Usuario("Javier", "Sanchez", "Martinez", "1215680968", LocalDate.of(1980, 10, 12), Usuario.Sexo.MASCULINO, Usuario.EnumEstCivil.UNION_LIBRE, "javisanchez", "javipass", false, null));
        usuarios.add(new Usuario("Andrea", "Gutierrez", "López", "1315680969", LocalDate.of(1976, 4, 5), Usuario.Sexo.FEMENINO, Usuario.EnumEstCivil.SOLTERO, "andreagutierrez", "andrea123", false, null));
        usuarios.add(new Usuario("Miguel", "Perez", "Gomez", "1415680970", LocalDate.of(1992, 11, 22), Usuario.Sexo.MASCULINO, Usuario.EnumEstCivil.VIUDO, "miguelperez", "miguelpass", true, null));
        usuarios.add(new Usuario("Paula", "Ramirez", "Herrera", "1515680971", LocalDate.of(1984, 6, 8), Usuario.Sexo.FEMENINO, Usuario.EnumEstCivil.DIVORCIADO, "paularamirez", "paula123", false, null));

        return usuarios;
    }
}
