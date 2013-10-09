/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.Segmento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Luis Henrique
 */
public class SegmentoDao {
    private EntityManager manager;

    public SegmentoDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pesquisasPU");
        manager = factory.createEntityManager();
    }

    // adiciona registro
    public Segmento add(Segmento segmento) {
        manager.getTransaction().begin();
        manager.persist(segmento);
        manager.getTransaction().commit();
        return segmento;
    }

    // atualiza registro
    public void update(Segmento segmento) {
        manager.getTransaction().begin();
        manager.merge(segmento);
        manager.getTransaction().commit();
    }

    // deleta registro
    public void delete(Segmento segmento) {
        manager.getTransaction().begin();
        manager.remove(segmento);
        manager.getTransaction().commit();
    }

    // encontra registro
    public Segmento find(int id) {
        return manager.find(Segmento.class, id);
    }

    // Lista todos registros
    public List<Segmento> list() {
        Query query = manager.createQuery("from Segmentos");
        return query.getResultList();
    }
    
}
