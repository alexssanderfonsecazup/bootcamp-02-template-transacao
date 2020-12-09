package br.com.bootcamp.zup.transacao;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {
    @Id
    @NotNull
    private String id;

    @NotNull @Positive
    private BigDecimal valor;

    @NotNull
    @Embedded
    private Estabelecimento estabelecimento;

    @Embedded
    @NotNull
    private Cartao cartao;

    @NotNull
    private LocalDateTime efetivadaEm;

    public Transacao(){}

    public Transacao(@NotNull String id, @NotNull @Positive BigDecimal valor,
                     @NotNull Estabelecimento estabelecimento, @NotNull  Cartao cartao,
                     @NotNull LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }


}
