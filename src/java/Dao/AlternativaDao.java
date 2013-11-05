/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.Alternativa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Luis Henrique
 */
public class AlternativaDao {
    private EntityManager manager;

    public AlternativaDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetoMarketingPU");
        manager = factory.createEntityManager();
    }

    // adiciona registro
    public Alternativa add(Alternativa alternativa) {
        manager.getTransaction().begin();
        manager.persist(alternativa);
        manager.getTransaction().commit();
        return alternativa;
    }
    
    // atualiza registro
    public void update(Alternativa alternativa) {
        manager.getTransaction().begin();
        manager.merge(alternativa);
        manager.getTransaction().commit();
    }

    // deleta registro
    public void delete(Alternativa alternativa) {
        manager.getTransaction().begin();
        manager.remove(alternativa);
        manager.getTransaction().commit();
    }

    // encontra registro
    public Alternativa find(int id) {
        return manager.find(Alternativa.class, id);
    }

    // Lista todos registros
    public List<Alternativa> list(int id) {
        Query query = manager.createQuery("from Alternativa WHERE questao.id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }
}
