/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.JefeBodega;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jcarlos
 */
@Stateless
public class JefeBodegaFacade extends AbstractFacade<JefeBodega> {

    @PersistenceContext(unitName = "CrudProyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JefeBodegaFacade() {
        super(JefeBodega.class);
    }
    
}
