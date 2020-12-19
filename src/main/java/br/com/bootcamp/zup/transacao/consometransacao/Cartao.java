package br.com.bootcamp.zup.transacao.consometransacao;

import br.com.bootcamp.zup.transacao.consultatransacao.Transacao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Cartao {

    @Id
    private String id;
    @NotBlank
    private String email;


    @OneToMany(mappedBy = "cartao")
    private Set<Transacao> transacoes;

    @Deprecated
    public Cartao(){}

    public Cartao(@NotNull String id, @NotBlank String email) {
        this.id = id;
        this.email = email;
    }

    public Set<Transacao> getTransacoes() {
        return transacoes;
    }

    public String getId() {
        return id;
    }

    public void setTransacoes(Set<Transacao> transacoes) {
        this.transacoes = transacoes;
    }
}
