package br.com.bootcamp.zup.transacao.consometransacao;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Embeddable
public class Cartao {

    private String idCartao;
    @NotBlank
    private String email;

    @Deprecated
    public Cartao(){}

    public Cartao(@NotNull String idCartao, @NotBlank String email) {
        this.idCartao = idCartao;
        this.email = email;
    }

    public String getIdCartao() {
        return idCartao;
    }
}
