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
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pesquisasPU");
        manager = factory.createEntityManager();
    }

    public Questao add(Questao questao) {
        manager.getTransaction().begin();
        manager.persist(questao);
        manager.getTransaction().commit();
        return questao;
    }

    public void update(Questao questao) {
        manager.getTransaction().begin();
        manager.merge(questao);
        manager.getTransaction().commit();
    }

    public void delete(Questao questao) {
        manager.getTransaction().begin();
        manager.remove(questao);
        manager.getTransaction().commit();
    }

    public Questao find(int id) {
        return manager.find(Questao.class, id);
    }

    public List<Questao> list() {
        Query query = manager.createQuery("from Questoes");
        return query.getResultList();
    }
}
