package br.com.bootcamp.zup.transacao.consometransacao.kafka.evento;

public class EventoDeTransacaoCartao {
    private String id;
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "EventoDeTransacaoCartao{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
