/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Luis Henrique
 */
public class Teste {

    public static void main(String args[]) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pesquisasPU");
        EntityManager manager = factory.createEntityManager();
    }
}
