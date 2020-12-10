package br.com.bootcamp.zup.transacao.consultatransacao;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TransacaoResponse {

    private String id;

    private BigDecimal valor;

    private String nomeEstabelecimento;

    private String idCartao;

    private LocalDateTime efetivadaEm;


    public TransacaoResponse(BigDecimal valor, String nomeEstabelecimento, String idCartao, LocalDateTime efetivadaEm) {
        this.valor = valor;
        this.nomeEstabelecimento = nomeEstabelecimento;
        this.idCartao = idCartao;
        this.efetivadaEm = efetivadaEm;
    }


    public TransacaoResponse(Transacao transacao){
        this.id = transacao.getId();
        this.idCartao = transacao.getCartao().getId();
        this.valor = transacao.getValor();
        this.nomeEstabelecimento = transacao.getEstabelecimento().getNome();
        this.efetivadaEm = transacao.getEfetivadaEm();
    }
    public static List<TransacaoResponse> toList(List<Transacao> transacoes){
        return transacoes.stream()
                .map(TransacaoResponse::new)
                .collect(Collectors.toList());
    }
    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public String getIdCartao() {
        return idCartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
