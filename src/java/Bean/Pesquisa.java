/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Luis Henrique
 */
@Entity
@Table(name = "Pesquisas")
public class Pesquisa {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 40)
    private String nome;
    private Integer tipo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataInicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataFim;
    @ManyToMany
    @JoinTable(name = "pesquisas_questoes",
            joinColumns =
            @JoinColumn(name = "pesquisa_id"),
            inverseJoinColumns =
            @JoinColumn(name = "questao_id"))
    private List<Questao> questoes;
    @ManyToOne
    @JoinColumn(name = "segmento_id")
    private Segmento segmento;

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateformat.parse(dataInicio));
        this.dataInicio = cal;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Calendar getDataFim() {
        return dataFim;
    }

    public String getDataFimView() {
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        String data = s.format(this.dataFim.getTime());
        return data;
    }

    public String getDataInicioView() {
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        String data = s.format(this.dataInicio.getTime());
        return data;
    }

    public void setDataFim(String dataFim) throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateformat.parse(dataFim));
        this.dataFim = cal;
    }

    public void setDataFim(Calendar dataFim) {
        this.dataFim = dataFim;
    }

    public Segmento getSegmento() {
        return segmento;
    }

    public void setSegmento(Segmento segmento) {
        this.segmento = segmento;
    }

    public String verificaData() {
        Date d = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(d);
        
        String msg;
        if (this.dataFim.before(cal)) {
            msg = "Finalizada";
        } else {
            msg = "Ativa";
        }
        return msg;
    }
}