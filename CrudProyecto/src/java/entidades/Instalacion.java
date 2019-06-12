/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jcarlos
 */
@Entity
@Table(name = "instalacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instalacion.findAll", query = "SELECT i FROM Instalacion i")
    , @NamedQuery(name = "Instalacion.findByIdInstalacion", query = "SELECT i FROM Instalacion i WHERE i.idInstalacion = :idInstalacion")
    , @NamedQuery(name = "Instalacion.findByDetalles", query = "SELECT i FROM Instalacion i WHERE i.detalles = :detalles")
    , @NamedQuery(name = "Instalacion.findByFechaSolicitudInstalacion", query = "SELECT i FROM Instalacion i WHERE i.fechaSolicitudInstalacion = :fechaSolicitudInstalacion")
    , @NamedQuery(name = "Instalacion.findByCantidadEquipo", query = "SELECT i FROM Instalacion i WHERE i.cantidadEquipo = :cantidadEquipo")})
public class Instalacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_instalacion")
    private Integer idInstalacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "detalles")
    private String detalles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_solicitud_instalacion")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitudInstalacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_equipo")
    private int cantidadEquipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIntalacion", fetch = FetchType.LAZY)
    private List<Cliente> clienteList;
    @JoinColumn(name = "id_tecnico", referencedColumnName = "id_intalacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Punto idTecnico;
    @JoinColumn(name = "id_supervisor", referencedColumnName = "id_supervisor")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Supervisor idSupervisor;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "instalacion", fetch = FetchType.LAZY)
    private Tecnico tecnico;

    public Instalacion() {
    }

    public Instalacion(Integer idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    public Instalacion(Integer idInstalacion, String detalles, Date fechaSolicitudInstalacion, int cantidadEquipo) {
        this.idInstalacion = idInstalacion;
        this.detalles = detalles;
        this.fechaSolicitudInstalacion = fechaSolicitudInstalacion;
        this.cantidadEquipo = cantidadEquipo;
    }

    public Integer getIdInstalacion() {
        return idInstalacion;
    }

    public void setIdInstalacion(Integer idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Date getFechaSolicitudInstalacion() {
        return fechaSolicitudInstalacion;
    }

    public void setFechaSolicitudInstalacion(Date fechaSolicitudInstalacion) {
        this.fechaSolicitudInstalacion = fechaSolicitudInstalacion;
    }

    public int getCantidadEquipo() {
        return cantidadEquipo;
    }

    public void setCantidadEquipo(int cantidadEquipo) {
        this.cantidadEquipo = cantidadEquipo;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    public Punto getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Punto idTecnico) {
        this.idTecnico = idTecnico;
    }

    public Supervisor getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(Supervisor idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstalacion != null ? idInstalacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instalacion)) {
            return false;
        }
        Instalacion other = (Instalacion) object;
        if ((this.idInstalacion == null && other.idInstalacion != null) || (this.idInstalacion != null && !this.idInstalacion.equals(other.idInstalacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Instalacion[ idInstalacion=" + idInstalacion + " ]";
    }
    
}
