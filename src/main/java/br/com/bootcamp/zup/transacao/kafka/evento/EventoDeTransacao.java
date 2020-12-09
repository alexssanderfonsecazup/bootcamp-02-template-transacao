package br.com.bootcamp.zup.transacao.kafka.evento;

import br.com.bootcamp.zup.transacao.Cartao;
import br.com.bootcamp.zup.transacao.Estabelecimento;
import br.com.bootcamp.zup.transacao.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class EventoDeTransacao {
    private String id;
    private BigDecimal valor;
    private EventoDeTransacaoEstabelecimento estabelecimento;
    private EventoDeTransacaoCartao cartao;
    private LocalDateTime efetivadaEm;


    public Transacao toModel(){
        Estabelecimento estabelecimento = new Estabelecimento(this.estabelecimento.getNome(),
                this.estabelecimento.getCidade(),this.estabelecimento.getEndereco());
        Cartao cartao = new Cartao(this.cartao.getId(),this.cartao.getEmail());
        return new Transacao(id,valor,estabelecimento,cartao,efetivadaEm);

    }

    @Override
    public String toString() {
        return "EventoDeTransacao{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EventoDeTransacaoEstabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public EventoDeTransacaoCartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
