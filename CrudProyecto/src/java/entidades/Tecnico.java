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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jcarlos
 */
@Entity
@Table(name = "tecnico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tecnico.findAll", query = "SELECT t FROM Tecnico t")
    , @NamedQuery(name = "Tecnico.findByIdTecnico", query = "SELECT t FROM Tecnico t WHERE t.idTecnico = :idTecnico")
    , @NamedQuery(name = "Tecnico.findByFechaIntalacion", query = "SELECT t FROM Tecnico t WHERE t.fechaIntalacion = :fechaIntalacion")
    , @NamedQuery(name = "Tecnico.findByHoraIntalacion", query = "SELECT t FROM Tecnico t WHERE t.horaIntalacion = :horaIntalacion")
    , @NamedQuery(name = "Tecnico.findByIdPunto", query = "SELECT t FROM Tecnico t WHERE t.idPunto = :idPunto")})
public class Tecnico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tecnico")
    private Integer idTecnico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_intalacion")
    @Temporal(TemporalType.DATE)
    private Date fechaIntalacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_intalacion")
    @Temporal(TemporalType.TIME)
    private Date horaIntalacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_punto")
    private int idPunto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTecnico", fetch = FetchType.LAZY)
    private List<Punto> puntoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tecnico", fetch = FetchType.LAZY)
    private Punto punto;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;
    @JoinColumn(name = "id_tecnico", referencedColumnName = "id_tecnico", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Instalacion instalacion;
    @JoinColumn(name = "id_supervisor", referencedColumnName = "id_tecnico")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Supervisor idSupervisor;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tecnico", fetch = FetchType.LAZY)
    private Supervisor supervisor;

    public Tecnico() {
    }

    public Tecnico(Integer idTecnico) {
        this.idTecnico = idTecnico;
    }

    public Tecnico(Integer idTecnico, Date fechaIntalacion, Date horaIntalacion, int idPunto) {
        this.idTecnico = idTecnico;
        this.fechaIntalacion = fechaIntalacion;
        this.horaIntalacion = horaIntalacion;
        this.idPunto = idPunto;
    }

    public Integer getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Integer idTecnico) {
        this.idTecnico = idTecnico;
    }

    public Date getFechaIntalacion() {
        return fechaIntalacion;
    }

    public void setFechaIntalacion(Date fechaIntalacion) {
        this.fechaIntalacion = fechaIntalacion;
    }

    public Date getHoraIntalacion() {
        return horaIntalacion;
    }

    public void setHoraIntalacion(Date horaIntalacion) {
        this.horaIntalacion = horaIntalacion;
    }

    public int getIdPunto() {
        return idPunto;
    }

    public void setIdPunto(int idPunto) {
        this.idPunto = idPunto;
    }

    @XmlTransient
    public List<Punto> getPuntoList() {
        return puntoList;
    }

    public void setPuntoList(List<Punto> puntoList) {
        this.puntoList = puntoList;
    }

    public Punto getPunto() {
        return punto;
    }

    public void setPunto(Punto punto) {
        this.punto = punto;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Instalacion getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(Instalacion instalacion) {
        this.instalacion = instalacion;
    }

    public Supervisor getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(Supervisor idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTecnico != null ? idTecnico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tecnico)) {
            return false;
        }
        Tecnico other = (Tecnico) object;
        if ((this.idTecnico == null && other.idTecnico != null) || (this.idTecnico != null && !this.idTecnico.equals(other.idTecnico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tecnico[ idTecnico=" + idTecnico + " ]";
    }
    
}
