/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jcarlos
 */
@Entity
@Table(name = "jefe_bodega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JefeBodega.findAll", query = "SELECT j FROM JefeBodega j")
    , @NamedQuery(name = "JefeBodega.findByIdJefeBodega", query = "SELECT j FROM JefeBodega j WHERE j.idJefeBodega = :idJefeBodega")
    , @NamedQuery(name = "JefeBodega.findByIndumentaria", query = "SELECT j FROM JefeBodega j WHERE j.indumentaria = :indumentaria")})
public class JefeBodega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_jefe_bodega")
    private Integer idJefeBodega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "indumentaria")
    private String indumentaria;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;
    @JoinColumn(name = "id_inventario", referencedColumnName = "id_inventario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Inventario idInventario;

    public JefeBodega() {
    }

    public JefeBodega(Integer idJefeBodega) {
        this.idJefeBodega = idJefeBodega;
    }

    public JefeBodega(Integer idJefeBodega, String indumentaria) {
        this.idJefeBodega = idJefeBodega;
        this.indumentaria = indumentaria;
    }

    public Integer getIdJefeBodega() {
        return idJefeBodega;
    }

    public void setIdJefeBodega(Integer idJefeBodega) {
        this.idJefeBodega = idJefeBodega;
    }

    public String getIndumentaria() {
        return indumentaria;
    }

    public void setIndumentaria(String indumentaria) {
        this.indumentaria = indumentaria;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Inventario getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Inventario idInventario) {
        this.idInventario = idInventario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJefeBodega != null ? idJefeBodega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JefeBodega)) {
            return false;
        }
        JefeBodega other = (JefeBodega) object;
        if ((this.idJefeBodega == null && other.idJefeBodega != null) || (this.idJefeBodega != null && !this.idJefeBodega.equals(other.idJefeBodega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.JefeBodega[ idJefeBodega=" + idJefeBodega + " ]";
    }
    
}
