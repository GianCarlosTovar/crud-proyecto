/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Usuario;
import facade.UsuarioFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Jcarlos
 */

@Named(value = "jSFManagedBean")
@RequestScoped
public class usuarioControlador {

    /**
     * Creates a new instance of JSFManagedBean
     */
    public usuarioControlador() {
        
    }
  @EJB  
  
  UsuarioFacade usuarioFacade;
  
  Usuario usuario = new Usuario();
  
  
    @PostConstruct
     
    public void init(){
        usuario = new Usuario();
        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
   
    
    public void registrar(){
        usuarioFacade.create(usuario);
    } 
    public void eliminar(Usuario usuario) {
        
        this.usuario = usuario;
        usuarioFacade.remove(usuario);
     
    }
    public List<Usuario> consultarTodos(){
        return usuarioFacade.findAll();
    }
    public String preEditar(Usuario usuario){
        this.usuario= usuario;
        return "actualizar";
    }
    public String editar(){
        usuarioFacade.edit(usuario);
        return "lista";
        
    }
        

  
}
