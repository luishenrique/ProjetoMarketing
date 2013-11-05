/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.Resposta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Luis Henrique
 */
public class RespostaDao {
    private EntityManager manager;

    public RespostaDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetoMarketingPU");
        manager = factory.createEntityManager();
    }

    // adiciona registro
    public Resposta add(Resposta resposta) {
        manager.getTransaction().begin();
        manager.persist(resposta);
        manager.getTransaction().commit();
        return resposta;
    }

    // atualiza registro
    public void update(Resposta resposta) {
        manager.getTransaction().begin();
        manager.merge(resposta);
        manager.getTransaction().commit();
    }

    // deleta registro
    public void delete(Resposta resposta) {
        manager.getTransaction().begin();
        manager.remove(resposta);
        manager.getTransaction().commit();
    }

    // encontra registro
    public Resposta find(int id) {
        return manager.find(Resposta.class, id);
    }

    // Lista todos registros
    public List<Resposta> list() {
        Query query = manager.createQuery("from Resposta");
        return query.getResultList();
    }
    
}
