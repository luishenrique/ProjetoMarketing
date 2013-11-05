/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import Bean.Pesquisa;
import Bean.Segmento;
import Dao.PesquisaDao;
import Dao.SegmentoDao;
import java.util.Calendar;
import java.util.TimeZone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Luis Henrique
 */
public class Teste {

    public static void main(String args[]) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetoMarketingPU");
        EntityManager manager = factory.createEntityManager();
        
        
    }
}
