package br.com.bootcamp.zup.transacao.consometransacao.kafka.evento;

import br.com.bootcamp.zup.transacao.consometransacao.Cartao;

public class EventoDeTransacaoCartao {
    private String id;
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }


    public Cartao toModel(){
        return new Cartao(id,email);
    }

    @Override
    public String toString() {
        return "EventoDeTransacaoCartao{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
