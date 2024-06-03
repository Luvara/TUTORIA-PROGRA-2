
package cr.ac.una.tutoria14.model;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Luvara
 */
public class UsuarioDto {
    public SimpleStringProperty id;
    public SimpleStringProperty nombre;
    public SimpleStringProperty primerApellido;
    public SimpleStringProperty segundoApellido;
    public ObjectProperty<String> genero;
    public SimpleStringProperty correo;
    private List<Comentario> comentarioList;
    private List<Publicacion> publicacionList;

    public UsuarioDto() {
       this.id = new SimpleStringProperty();
        this.nombre = new SimpleStringProperty();
        this.primerApellido = new SimpleStringProperty();
        this.segundoApellido = new SimpleStringProperty();
        this.genero = new SimpleObjectProperty("M");
        this.correo = new SimpleStringProperty();
        this.comentarioList = new ArrayList<>();
        this.publicacionList = new ArrayList<>();
    }

    public UsuarioDto(Usuario usuario){
        this();
        this.id.set(usuario.getId().toString());
        this.nombre.set(usuario.getNombre());
        this.primerApellido.set(usuario.getPrimerApellido());
        this.segundoApellido.set(usuario.getSegundoApellido());
        this.genero.set(usuario.getGenero());
        this.correo.set(usuario.getCorreo());
        this.comentarioList = usuario.getComentarioList();
        this.publicacionList = usuario.getPublicacionList();
    }

    public Long getId() {
       if (this.id.get() != null && !this.id.get().isEmpty()) {
            return Long.valueOf(this.id.get());
        } else {
            return null;
        }
    }

    public void setId(Long id) {
        this.id.set(id.toString());
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getPrimerApellido() {
        return primerApellido.get();
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido.set(primerApellido);
    }

    public String getSegundoApellido() {
        return segundoApellido.get();
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido.set(segundoApellido);
    }

    public String getGenero() {
        return genero.get();
    }

    public void setGenero(String genero) {
        this.genero.set(genero);
    }

    public String getCorreo() {
        return correo.get();
    }

    public void setCorreo(String correo) {
        this.correo.set(correo);
    }

    public List<Comentario> getComentarioList() {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }

    public List<Publicacion> getPublicacionList() {
        return publicacionList;
    }

    public void setPublicacionList(List<Publicacion> publicacionList) {
        this.publicacionList = publicacionList;
    }
    
    
}
