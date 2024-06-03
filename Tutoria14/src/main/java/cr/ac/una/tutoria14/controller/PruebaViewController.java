package cr.ac.una.tutoria14.controller;

import cr.ac.una.tutoria14.model.UsuarioDto;
import cr.ac.una.tutoria14.service.UsuariosService;
import cr.ac.una.tutoria14.util.Respuesta;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Luvara
 */
public class PruebaViewController extends Controller implements Initializable {

    @FXML
    private Button btnPruebas;
    @FXML
    private TableView<UsuarioDto> tbvPruebas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cargarTabla();
    }

    @Override
    public void initialize() {
    }

    @FXML
    private void btnPruebas(ActionEvent event) {
        tbvPruebas.getItems().clear();
        UsuariosService service = new UsuariosService();

        Respuesta respuesta = service.getUsuarios();

        if (respuesta.getEstado()) {
            //ObservableList<UsuarioDto> usuarios = FXCollections.observableArrayList((List<UsuarioDto>) respuesta.getResultado("Usuarios"));
            List<UsuarioDto> listaBD = (List<UsuarioDto>) respuesta.getResultado("Usuarios");
            ObservableList<UsuarioDto> usuarios = FXCollections.observableArrayList(filtroNombre(listaBD));
            System.out.println(usuarios.size());
            tbvPruebas.setItems(usuarios);
            tbvPruebas.refresh();
        } else {
            // new Mensaje().showModal(Alert.AlertType.ERROR, "Consultar Empleados", getStage(), respuesta.getMensaje());
        }
    }

    public void cargarTabla() {
        tbvPruebas.getItems().clear();
        tbvPruebas.getColumns().clear();

        TableColumn<UsuarioDto, String> tbcNombre = new TableColumn<>("Nombre");
        tbcNombre.setPrefWidth(100);
        tbcNombre.setCellValueFactory(cd -> cd.getValue().nombre);

        TableColumn<UsuarioDto, String> tbcPriApellido = new TableColumn<>("Primer Apellido");
        tbcPriApellido.setPrefWidth(200);
        tbcPriApellido.setCellValueFactory(cd -> cd.getValue().primerApellido);

        TableColumn<UsuarioDto, String> tbcSegApellido = new TableColumn<>("Segundo Apellido");
        tbcSegApellido.setPrefWidth(200);
        tbcSegApellido.setCellValueFactory(cd -> cd.getValue().segundoApellido);

        TableColumn<UsuarioDto, String> tbcCorreo = new TableColumn<>("Correo");
        tbcCorreo.setPrefWidth(200);
        tbcCorreo.setCellValueFactory(cd -> cd.getValue().correo);

        tbvPruebas.getColumns().add(tbcNombre);
        tbvPruebas.getColumns().add(tbcPriApellido);
        tbvPruebas.getColumns().add(tbcSegApellido);
        tbvPruebas.getColumns().add(tbcCorreo);
        tbvPruebas.refresh();
    }

    public List<UsuarioDto> filtroNombre(List<UsuarioDto> usuarios) {
        return usuarios.stream()
                .filter(usuario -> usuario.getNombre().equalsIgnoreCase("Luis"))
                .collect(Collectors.toList());
    }

}

/*

----------------Filtrar por género:

public List<UsuarioDto> filtrarPorGenero(List<UsuarioDto> usuarios, String genero) {
    return usuarios.stream()
            .filter(usuario -> usuario.getGenero().equalsIgnoreCase(genero))
            .collect(Collectors.toList());
}

----------------Obtener correos de todos los usuarios:

public List<String> obtenerCorreos(List<UsuarioDto> usuarios) {
    return usuarios.stream()
            .map(UsuarioDto::getCorreo)
            .collect(Collectors.toList());
}

----------------Filtrar por apellido:

public List<UsuarioDto> filtrarPorPrimerApellido(List<UsuarioDto> usuarios, String primerApellido) {
    return usuarios.stream()
            .filter(usuario -> usuario.getPrimerApellido().equalsIgnoreCase(primerApellido))
            .collect(Collectors.toList());
}

----------------Concatenar nombres completos de los usuarios:

public List<String> obtenerNombresCompletos(List<UsuarioDto> usuarios) {
    return usuarios.stream()
            .map(usuario -> usuario.getNombre() + " " + usuario.getPrimerApellido() + " " + usuario.getSegundoApellido())
            .collect(Collectors.toList());
}

----------------Contar usuarios por género:

public long contarUsuariosPorGenero(List<UsuarioDto> usuarios, String genero) {
    return usuarios.stream()
            .filter(usuario -> usuario.getGenero().equalsIgnoreCase(genero))
            .count();
}

----------------Agrupar usuarios por género:

public Map<String, List<UsuarioDto>> agruparPorGenero(List<UsuarioDto> usuarios) {
    return usuarios.stream()
            .collect(Collectors.groupingBy(usuario -> usuario.getGenero().toLowerCase()));
}

----------------Convertir lista de usuarios a mapa con el id como clave:

public Map<String, UsuarioDto> convertirAIdMap(List<UsuarioDto> usuarios) {
    return usuarios.stream()
            .collect(Collectors.toMap(UsuarioDto::getId, usuario -> usuario));
}

----------------Filtrar por nombre y ordenar por apellido:

public List<UsuarioDto> filtrarYOrdenarPorApellido(List<UsuarioDto> usuarios, String nombre) {
    return usuarios.stream()
            .filter(usuario -> usuario.getNombre().equalsIgnoreCase(nombre))
            .sorted(Comparator.comparing(UsuarioDto::getPrimerApellido))
            .collect(Collectors.toList());
}*/


