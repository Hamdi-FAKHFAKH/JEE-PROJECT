/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.Demande;

/**
 *
 * @author hamdi
 */
@Stateless
public class DemandeFacade extends AbstractFacade<Demande> implements DemandeFacadeLocal {

    @PersistenceContext(unitName = "projetJEEPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DemandeFacade() {
        super(Demande.class);
    }
    
}
