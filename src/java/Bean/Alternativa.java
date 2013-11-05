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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Luis Henrique
 */
@Entity
@Table(name = "Alternativas")
public class Alternativa {

    @Id
    @GeneratedValue
    private Integer id;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "questoes_id", referencedColumnName = "id")
    private Questao questao;

    @ManyToMany
    @JoinTable(name = "alternativas_respostas",
    joinColumns = @JoinColumn(name = "alternativa_id"),
    inverseJoinColumns = @JoinColumn(name = "resposta_id"))
    private List<Resposta> respostas;

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

}
