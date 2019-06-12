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
@Table(name = "inventarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i")
    , @NamedQuery(name = "Inventario.findByIdInventario", query = "SELECT i FROM Inventario i WHERE i.idInventario = :idInventario")
    , @NamedQuery(name = "Inventario.findByCodigoEquipo", query = "SELECT i FROM Inventario i WHERE i.codigoEquipo = :codigoEquipo")
    , @NamedQuery(name = "Inventario.findByDescripcion", query = "SELECT i FROM Inventario i WHERE i.descripcion = :descripcion")
    , @NamedQuery(name = "Inventario.findByExistenciaEmpresa", query = "SELECT i FROM Inventario i WHERE i.existenciaEmpresa = :existenciaEmpresa")
    , @NamedQuery(name = "Inventario.findByIdCliente", query = "SELECT i FROM Inventario i WHERE i.idCliente = :idCliente")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_inventario")
    private Integer idInventario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_equipo")
    private int codigoEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "existencia_empresa")
    private String existenciaEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cliente")
    private int idCliente;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "inventario", fetch = FetchType.LAZY)
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInventario", fetch = FetchType.LAZY)
    private List<JefeBodega> jefeBodegaList;
    @JoinColumn(name = "id_supervisor", referencedColumnName = "id_supervisor")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Supervisor idSupervisor;

    public Inventario() {
    }

    public Inventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public Inventario(Integer idInventario, int codigoEquipo, String descripcion, String existenciaEmpresa, int idCliente) {
        this.idInventario = idInventario;
        this.codigoEquipo = codigoEquipo;
        this.descripcion = descripcion;
        this.existenciaEmpresa = existenciaEmpresa;
        this.idCliente = idCliente;
    }

    public Integer getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public int getCodigoEquipo() {
        return codigoEquipo;
    }

    public void setCodigoEquipo(int codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getExistenciaEmpresa() {
        return existenciaEmpresa;
    }

    public void setExistenciaEmpresa(String existenciaEmpresa) {
        this.existenciaEmpresa = existenciaEmpresa;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @XmlTransient
    public List<JefeBodega> getJefeBodegaList() {
        return jefeBodegaList;
    }

    public void setJefeBodegaList(List<JefeBodega> jefeBodegaList) {
        this.jefeBodegaList = jefeBodegaList;
    }

    public Supervisor getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(Supervisor idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInventario != null ? idInventario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.idInventario == null && other.idInventario != null) || (this.idInventario != null && !this.idInventario.equals(other.idInventario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Inventario[ idInventario=" + idInventario + " ]";
    }
    
}
