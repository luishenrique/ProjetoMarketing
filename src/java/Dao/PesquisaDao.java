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
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetoMarketingPU");
        manager = factory.createEntityManager();
    }

    // adiciona registro
    public Pesquisa add(Pesquisa pesquisa) {
        manager.getTransaction().begin();
        manager.persist(pesquisa);
        manager.getTransaction().commit();
        return pesquisa;
    }
    
    // atualiza registro
    public void update(Pesquisa pesquisa) {
        manager.getTransaction().begin();
        manager.merge(pesquisa);
        manager.getTransaction().commit();
    }

    // deleta registro
    public void delete(Pesquisa pesquisa) {
        manager.getTransaction().begin();
        manager.remove(pesquisa);
        manager.getTransaction().commit();
    }

    // encontra registro
    public Pesquisa find(int id) {
        return manager.find(Pesquisa.class, id);
    }

    // Lista todos registros
    public List<Pesquisa> list() {
        Query query = manager.createQuery("from Pesquisa");
        return query.getResultList();
    }
}
