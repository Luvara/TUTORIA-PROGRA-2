/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tutoria14.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Luvara
 */
@Entity
@Table(name = "COMENTARIO")
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c"),
    @NamedQuery(name = "Comentario.findByComId", query = "SELECT c FROM Comentario c WHERE c.comId = :comId"),
    @NamedQuery(name = "Comentario.findByComContenido", query = "SELECT c FROM Comentario c WHERE c.comContenido = :comContenido"),
    @NamedQuery(name = "Comentario.findByComFechaComentario", query = "SELECT c FROM Comentario c WHERE c.comFechaComentario = :comFechaComentario")})
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "COM_ID")
    private BigDecimal comId;
    @Basic(optional = false)
    @Column(name = "COM_CONTENIDO")
    private String comContenido;
    @Basic(optional = false)
    @Column(name = "COM_FECHA_COMENTARIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date comFechaComentario;
    @JoinColumn(name = "PUB_ID", referencedColumnName = "PUB_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Publicacion pubId;
    @JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuId;

    public Comentario() {
    }

    public Comentario(BigDecimal comId) {
        this.comId = comId;
    }

    public Comentario(BigDecimal comId, String comContenido, Date comFechaComentario) {
        this.comId = comId;
        this.comContenido = comContenido;
        this.comFechaComentario = comFechaComentario;
    }

    public BigDecimal getComId() {
        return comId;
    }

    public void setComId(BigDecimal comId) {
        this.comId = comId;
    }

    public String getComContenido() {
        return comContenido;
    }

    public void setComContenido(String comContenido) {
        this.comContenido = comContenido;
    }

    public Date getComFechaComentario() {
        return comFechaComentario;
    }

    public void setComFechaComentario(Date comFechaComentario) {
        this.comFechaComentario = comFechaComentario;
    }

    public Publicacion getPubId() {
        return pubId;
    }

    public void setPubId(Publicacion pubId) {
        this.pubId = pubId;
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
        hash += (comId != null ? comId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.comId == null && other.comId != null) || (this.comId != null && !this.comId.equals(other.comId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.tutoria14.model.Comentario[ comId=" + comId + " ]";
    }
    
}
