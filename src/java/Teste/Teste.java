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
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pesquisasPU");
        EntityManager manager = factory.createEntityManager();
        
        Segmento seg = new Segmento();
        SegmentoDao daoseg = new SegmentoDao();
        
        seg.setNome("Segmento Teste");
        
        daoseg.add(seg);
        
        
        Pesquisa p = new Pesquisa();
        PesquisaDao daop = new PesquisaDao();
        
        p.setDataInicio(Calendar.getInstance());
        p.setDataFim(Calendar.getInstance());
        p.setNome("Pesquisa Teste");
        p.setSegmento(seg);
        p.setTipo(1);
        daop.add(p);
        
        
        
    }
}
