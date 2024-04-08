package cr.ac.una.tutoria2.controller;

import cr.ac.una.tutoria2.model.Usuario;
import cr.ac.una.tutoria2.util.AppContext;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Luvara
 */
public class MantenimientoGeneralesViewController extends Controller implements Initializable {

    @FXML
    private TableView<Usuario> tbvListaUsuarios;
    @FXML
    private TableColumn<Usuario, String> tbcCedula;
    @FXML
    private TableColumn<Usuario, String> tbcNombre;
    @FXML
    private TableColumn<Usuario, String> tbcPriApellido;
    @FXML
    private TableColumn<Usuario, String> tbcSegApellifo;

    List<Usuario> listaUsuario = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        listaUsuario = (List<Usuario>) AppContext.getInstance().get("LISTAUSUARIOS");

        anadirSlots();

        ObservableList<Usuario> listaUsuariosObservable = FXCollections.observableArrayList(listaUsuario);
        tbvListaUsuarios.setItems(listaUsuariosObservable);
        tbvListaUsuarios.refresh();

    }

    @Override
    public void initialize() {
    }

    public void anadirSlots() {

        tbvListaUsuarios.getItems().clear();

        tbcCedula.setCellValueFactory(cd -> {
            return new SimpleStringProperty(cd.getValue().getCedula());
        });
        tbcNombre.setCellValueFactory(cd -> {
            return new SimpleStringProperty(cd.getValue().getNombre());
        });
        tbcPriApellido.setCellValueFactory(cd -> {
            return new SimpleStringProperty(cd.getValue().getPrimerApellido());
        });
        tbcSegApellifo.setCellValueFactory(cd -> {
            return new SimpleStringProperty(cd.getValue().getSegundoApellido());
        });

        tbvListaUsuarios.refresh();
    }

}
