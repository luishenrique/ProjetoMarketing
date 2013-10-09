/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.Pesquisa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Luis Henrique
 */
public class PesquisaDao {

    private EntityManager manager;

    public PesquisaDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pesquisasPU");
        manager = factory.createEntityManager();
    }

    public Pesquisa add(Pesquisa pesquisa) {
        manager.getTransaction().begin();
        manager.persist(pesquisa);
        manager.getTransaction().commit();
        return pesquisa;
    }
    
    public void update(Pesquisa pesquisa) {
        manager.getTransaction().begin();
        manager.merge(pesquisa);
        manager.getTransaction().commit();
    }

    public void delete(Pesquisa pesquisa) {
        manager.getTransaction().begin();
        manager.remove(pesquisa);
        manager.getTransaction().commit();
    }

    public Pesquisa find(int id) {
        return manager.find(Pesquisa.class, id);
    }

    public List<Pesquisa> list() {
        Query query = manager.createQuery("from Pesquisas");
        return query.getResultList();
    }
}
