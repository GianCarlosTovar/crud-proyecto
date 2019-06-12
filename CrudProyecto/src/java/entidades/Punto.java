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
@Table(name = "punto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Punto.findAll", query = "SELECT p FROM Punto p")
    , @NamedQuery(name = "Punto.findByIdPunto", query = "SELECT p FROM Punto p WHERE p.idPunto = :idPunto")
    , @NamedQuery(name = "Punto.findByCantidadPunto", query = "SELECT p FROM Punto p WHERE p.cantidadPunto = :cantidadPunto")
    , @NamedQuery(name = "Punto.findByFechaIntalacion", query = "SELECT p FROM Punto p WHERE p.fechaIntalacion = :fechaIntalacion")
    , @NamedQuery(name = "Punto.findByServicio", query = "SELECT p FROM Punto p WHERE p.servicio = :servicio")
    , @NamedQuery(name = "Punto.findByUbicasion", query = "SELECT p FROM Punto p WHERE p.ubicasion = :ubicasion")
    , @NamedQuery(name = "Punto.findByIdIntalacion", query = "SELECT p FROM Punto p WHERE p.idIntalacion = :idIntalacion")})
public class Punto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_punto")
    private Integer idPunto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_punto")
    private int cantidadPunto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_intalacion")
    @Temporal(TemporalType.DATE)
    private Date fechaIntalacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "servicio")
    private String servicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "ubicasion")
    private String ubicasion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_intalacion")
    private int idIntalacion;
    @JoinColumn(name = "id_tecnico", referencedColumnName = "id_tecnico")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tecnico idTecnico;
    @JoinColumn(name = "id_punto", referencedColumnName = "id_punto", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Tecnico tecnico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTecnico", fetch = FetchType.LAZY)
    private List<Instalacion> instalacionList;

    public Punto() {
    }

    public Punto(Integer idPunto) {
        this.idPunto = idPunto;
    }

    public Punto(Integer idPunto, int cantidadPunto, Date fechaIntalacion, String servicio, String ubicasion, int idIntalacion) {
        this.idPunto = idPunto;
        this.cantidadPunto = cantidadPunto;
        this.fechaIntalacion = fechaIntalacion;
        this.servicio = servicio;
        this.ubicasion = ubicasion;
        this.idIntalacion = idIntalacion;
    }

    public Integer getIdPunto() {
        return idPunto;
    }

    public void setIdPunto(Integer idPunto) {
        this.idPunto = idPunto;
    }

    public int getCantidadPunto() {
        return cantidadPunto;
    }

    public void setCantidadPunto(int cantidadPunto) {
        this.cantidadPunto = cantidadPunto;
    }

    public Date getFechaIntalacion() {
        return fechaIntalacion;
    }

    public void setFechaIntalacion(Date fechaIntalacion) {
        this.fechaIntalacion = fechaIntalacion;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getUbicasion() {
        return ubicasion;
    }

    public void setUbicasion(String ubicasion) {
        this.ubicasion = ubicasion;
    }

    public int getIdIntalacion() {
        return idIntalacion;
    }

    public void setIdIntalacion(int idIntalacion) {
        this.idIntalacion = idIntalacion;
    }

    public Tecnico getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Tecnico idTecnico) {
        this.idTecnico = idTecnico;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    @XmlTransient
    public List<Instalacion> getInstalacionList() {
        return instalacionList;
    }

    public void setInstalacionList(List<Instalacion> instalacionList) {
        this.instalacionList = instalacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPunto != null ? idPunto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Punto)) {
            return false;
        }
        Punto other = (Punto) object;
        if ((this.idPunto == null && other.idPunto != null) || (this.idPunto != null && !this.idPunto.equals(other.idPunto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Punto[ idPunto=" + idPunto + " ]";
    }
    
}
