/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.Supervisor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jcarlos
 */
@Stateless
public class SupervisorFacade extends AbstractFacade<Supervisor> {

    @PersistenceContext(unitName = "CrudProyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SupervisorFacade() {
        super(Supervisor.class);
    }
    
}
