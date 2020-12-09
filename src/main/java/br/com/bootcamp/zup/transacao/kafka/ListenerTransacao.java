package br.com.bootcamp.zup.transacao.kafka;

import br.com.bootcamp.zup.transacao.Transacao;
import br.com.bootcamp.zup.transacao.kafka.evento.EventoDeTransacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class ListenerTransacao {

     @PersistenceContext
     EntityManager entityManager;


    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    @Transactional
    public void ouvir(EventoDeTransacao eventoDeTransacao) {
        eventoDeTransacao.getCartao().getId();
        Transacao transacao = eventoDeTransacao.toModel();
        entityManager.persist(transacao);

    }
}
