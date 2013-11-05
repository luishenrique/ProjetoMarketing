/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.Questao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Luis Henrique
 */
public class QuestaoDao {
    private EntityManager manager;

    public QuestaoDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetoMarketingPU");
        manager = factory.createEntityManager();
    }

    // adiciona registro
    public Questao add(Questao questao) {
        manager.getTransaction().begin();
        manager.persist(questao);
        manager.getTransaction().commit();
        return questao;
    }

    // atualiza registro
    public void update(Questao questao) {
        manager.getTransaction().begin();
        manager.merge(questao);
        manager.getTransaction().commit();
    }

    // deleta registro
    public void delete(Questao questao) {
        manager.getTransaction().begin();
        manager.remove(questao);
        manager.getTransaction().commit();
    }

    // encontra registro
    public Questao find(int id) {
        return manager.find(Questao.class, id);
    }

    // Lista todos registros
    public List<Questao> list(int id) {
        Query query = manager.createQuery("from Questao WHERE pesquisa.id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }
}
