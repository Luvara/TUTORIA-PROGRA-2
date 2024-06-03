/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tutoria14.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Luvara
 */
@Entity
@Table(name = "PUBLICACION")
@NamedQueries({
    @NamedQuery(name = "Publicacion.findAll", query = "SELECT p FROM Publicacion p"),
    @NamedQuery(name = "Publicacion.findByPubId", query = "SELECT p FROM Publicacion p WHERE p.pubId = :pubId"),
    @NamedQuery(name = "Publicacion.findByPubTitulo", query = "SELECT p FROM Publicacion p WHERE p.pubTitulo = :pubTitulo"),
    @NamedQuery(name = "Publicacion.findByPubContenido", query = "SELECT p FROM Publicacion p WHERE p.pubContenido = :pubContenido"),
    @NamedQuery(name = "Publicacion.findByPubFechaPublicacion", query = "SELECT p FROM Publicacion p WHERE p.pubFechaPublicacion = :pubFechaPublicacion")})
public class Publicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PUB_ID")
    private BigDecimal pubId;
    @Basic(optional = false)
    @Column(name = "PUB_TITULO")
    private String pubTitulo;
    @Basic(optional = false)
    @Column(name = "PUB_CONTENIDO")
    private String pubContenido;
    @Basic(optional = false)
    @Column(name = "PUB_FECHA_PUBLICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pubFechaPublicacion;
    @OneToMany(mappedBy = "pubId", fetch = FetchType.LAZY)
    private List<Comentario> comentarioList;
    @JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuId;

    public Publicacion() {
    }

    public Publicacion(BigDecimal pubId) {
        this.pubId = pubId;
    }

    public Publicacion(BigDecimal pubId, String pubTitulo, String pubContenido, Date pubFechaPublicacion) {
        this.pubId = pubId;
        this.pubTitulo = pubTitulo;
        this.pubContenido = pubContenido;
        this.pubFechaPublicacion = pubFechaPublicacion;
    }

    public BigDecimal getPubId() {
        return pubId;
    }

    public void setPubId(BigDecimal pubId) {
        this.pubId = pubId;
    }

    public String getPubTitulo() {
        return pubTitulo;
    }

    public void setPubTitulo(String pubTitulo) {
        this.pubTitulo = pubTitulo;
    }

    public String getPubContenido() {
        return pubContenido;
    }

    public void setPubContenido(String pubContenido) {
        this.pubContenido = pubContenido;
    }

    public Date getPubFechaPublicacion() {
        return pubFechaPublicacion;
    }

    public void setPubFechaPublicacion(Date pubFechaPublicacion) {
        this.pubFechaPublicacion = pubFechaPublicacion;
    }

    public List<Comentario> getComentarioList() {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }

    public Usuario getUsuId() {
        return usuId;
    }

    public void setUsuId(Usuario usuId) {
        this.usuId = usuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pubId != null ? pubId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publicacion)) {
            return false;
        }
        Publicacion other = (Publicacion) object;
        if ((this.pubId == null && other.pubId != null) || (this.pubId != null && !this.pubId.equals(other.pubId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.tutoria14.model.Publicacion[ pubId=" + pubId + " ]";
    }
    
}
