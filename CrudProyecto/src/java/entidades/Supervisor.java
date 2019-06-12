/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jcarlos
 */
@Entity
@Table(name = "supervisor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supervisor.findAll", query = "SELECT s FROM Supervisor s")
    , @NamedQuery(name = "Supervisor.findByIdSupervisor", query = "SELECT s FROM Supervisor s WHERE s.idSupervisor = :idSupervisor")
    , @NamedQuery(name = "Supervisor.findByZonaIntalacion", query = "SELECT s FROM Supervisor s WHERE s.zonaIntalacion = :zonaIntalacion")
    , @NamedQuery(name = "Supervisor.findByIdTecnico", query = "SELECT s FROM Supervisor s WHERE s.idTecnico = :idTecnico")})
public class Supervisor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_supervisor")
    private Integer idSupervisor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "zona_intalacion")
    private String zonaIntalacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tecnico")
    private int idTecnico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSupervisor", fetch = FetchType.LAZY)
    private List<Instalacion> instalacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSupervisor", fetch = FetchType.LAZY)
    private List<Inventario> inventarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSupervisor", fetch = FetchType.LAZY)
    private List<Tecnico> tecnicoList;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;
    @JoinColumn(name = "id_supervisor", referencedColumnName = "id_supervisor", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Tecnico tecnico;

    public Supervisor() {
    }

    public Supervisor(Integer idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public Supervisor(Integer idSupervisor, String zonaIntalacion, int idTecnico) {
        this.idSupervisor = idSupervisor;
        this.zonaIntalacion = zonaIntalacion;
        this.idTecnico = idTecnico;
    }

    public Integer getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(Integer idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public String getZonaIntalacion() {
        return zonaIntalacion;
    }

    public void setZonaIntalacion(String zonaIntalacion) {
        this.zonaIntalacion = zonaIntalacion;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    @XmlTransient
    public List<Instalacion> getInstalacionList() {
        return instalacionList;
    }

    public void setInstalacionList(List<Instalacion> instalacionList) {
        this.instalacionList = instalacionList;
    }

    @XmlTransient
    public List<Inventario> getInventarioList() {
        return inventarioList;
    }

    public void setInventarioList(List<Inventario> inventarioList) {
        this.inventarioList = inventarioList;
    }

    @XmlTransient
    public List<Tecnico> getTecnicoList() {
        return tecnicoList;
    }

    public void setTecnicoList(List<Tecnico> tecnicoList) {
        this.tecnicoList = tecnicoList;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
        hash += (idSupervisor != null ? idSupervisor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supervisor)) {
            return false;
        }
        Supervisor other = (Supervisor) object;
        if ((this.idSupervisor == null && other.idSupervisor != null) || (this.idSupervisor != null && !this.idSupervisor.equals(other.idSupervisor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Supervisor[ idSupervisor=" + idSupervisor + " ]";
    }
    
}
