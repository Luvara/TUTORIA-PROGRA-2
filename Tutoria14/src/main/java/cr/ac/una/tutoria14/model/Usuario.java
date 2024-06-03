package cr.ac.una.tutoria14.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Luvara
 */
@Entity
@Table(name = "USUARIOS", schema = "UNA")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
/*,
    @NamedQuery(name = "Usuario.findByUsuId", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByUsuNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByUsuPrimerapellido", query = "SELECT u FROM Usuario u WHERE u.primerApellido = :primerApellido"),
    @NamedQuery(name = "Usuario.findByUsuSegundoapellido", query = "SELECT u FROM Usuario u WHERE u.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Usuario.findByUsuGenero", query = "SELECT u FROM Usuario u WHERE u.genero = :genero"),
    @NamedQuery(name = "Usuario.findByUsuCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo")*/
})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "USUARIOS_GENERATOR", sequenceName = "una.USUARIOS_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIOS_GENERATOR")
    @Basic(optional = false)
    @Column(name = "USU_ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "USU_NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "USU_PRIMERAPELLIDO")
    private String primerApellido;
    @Column(name = "USU_SEGUNDOAPELLIDO")
    private String segundoApellido;
    @Basic(optional = false)
    @Column(name = "USU_GENERO")
    private String genero;
    @Basic(optional = false)
    @Column(name = "USU_CORREO")
    private String correo;
    @OneToMany(mappedBy = "usuId", fetch = FetchType.LAZY)
    private List<Comentario> comentarioList;
    @OneToMany(mappedBy = "usuId", fetch = FetchType.LAZY)
    private List<Publicacion> publicacionList;

    public Usuario() {
    }

    public Usuario(Long usuId) {
        this.id = usuId;
    }
    
     public Usuario(UsuarioDto usuarioDto) {
        Actualizar(usuarioDto);
    }

 public void Actualizar(UsuarioDto usuarioDto) {
        this.id = usuarioDto.getId();
        this.nombre = usuarioDto.getNombre();
        this.primerApellido = usuarioDto.getPrimerApellido();
        this.segundoApellido = usuarioDto.getSegundoApellido();
        this.genero = usuarioDto.getGenero();
        this.correo = usuarioDto.getCorreo();
        this.publicacionList = usuarioDto.getPublicacionList();
        this.comentarioList = usuarioDto.getComentarioList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.tutoria14.model.Usuario[ usuId=" + id + " ]";
    }

}
