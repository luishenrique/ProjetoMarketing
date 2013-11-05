/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

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

/**
 *
 * @author Luis Henrique
 */
@Entity
@Table(name = "Respostas")
public class Resposta {
    @Id
    @GeneratedValue
    private Integer id;
    
    private String comentario;
    private Integer idade;
    private String sexo;
    
    @ManyToOne
    @JoinColumn(name="pesquisas_id", referencedColumnName="id")    
    Pesquisa pesquisa;
    
    @ManyToOne
    @JoinColumn(name="questoes_id", referencedColumnName="id")   
    private Questao questao;
    
    @ManyToMany
    @JoinTable(name = "alternativas_respostas",
    joinColumns = @JoinColumn(name = "resposta_id"),
    inverseJoinColumns = @JoinColumn(name = "alternativa_id"))
    private List<Alternativa> alternativas;

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;  
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Pesquisa getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(Pesquisa pesquisa) {
        this.pesquisa = pesquisa;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }    
    
}
