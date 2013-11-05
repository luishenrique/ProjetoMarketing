/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Luis Henrique
 */
@Entity
@Table(name = "Questoes")
public class Questao {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer tipo;
    private String descricao;
    
    @ManyToMany
    @JoinTable(name = "pesquisas_questoes",
    joinColumns=@JoinColumn(name="questao_id"),
    inverseJoinColumns=@JoinColumn(name="pesquisa_id"))  
    private List<Pesquisa> pesquisas;    
    
    @OneToMany(mappedBy = "questao")
    private List<Alternativa> alternativas;

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }
    
    public List<Pesquisa> getPesquisas() {
        return pesquisas;
    }

    public void setPesquisas(List<Pesquisa> pesquisas) {
        this.pesquisas = pesquisas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
