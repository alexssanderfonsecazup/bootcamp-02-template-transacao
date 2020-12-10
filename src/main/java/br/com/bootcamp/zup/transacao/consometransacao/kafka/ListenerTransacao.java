package br.com.bootcamp.zup.transacao.consometransacao.kafka;

import br.com.bootcamp.zup.transacao.consometransacao.Cartao;
import br.com.bootcamp.zup.transacao.consometransacao.kafka.evento.EventoDeTransacao;
import br.com.bootcamp.zup.transacao.consultatransacao.Transacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class ListenerTransacao {

    @PersistenceContext
    EntityManager entityManager;

    private final Logger logger = LoggerFactory.getLogger(ListenerTransacao.class);

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    @Transactional
    public void escutaPorTransacoes(EventoDeTransacao eventoDeTransacao) {

        String id = eventoDeTransacao.getCartao().getId();
        Cartao cartaoPersistido = entityManager.find(Cartao.class, id);
        if (cartaoPersistido == null) {
            Transacao transacao = eventoDeTransacao.toModel();
            entityManager.persist(transacao);
            logger.info("Cartao {} persistido e transação associada {} ",transacao.getCartao().getId(), transacao.getId());

            return;
        }
        Transacao transacao = eventoDeTransacao.toModel();
        entityManager.createQuery("INSERT INTO transacao (id, efetivada_em, cidade, endereco, nome, valor,cartao_id) VALUES (:id,:efetivada_em,:cidade,:endereco,:nome,:valor,:cartao_id)")

                .setParameter("id", eventoDeTransacao.getId())
                .setParameter("efetivada_em", eventoDeTransacao.getEfetivadaEm())
                .setParameter("cidade", eventoDeTransacao.getEstabelecimento().getCidade())
                .setParameter("endereco", eventoDeTransacao.getEstabelecimento().getEndereco())
                .setParameter("nome", eventoDeTransacao.getEstabelecimento().getNome())
                .setParameter("valor", eventoDeTransacao.getValor())
                .setParameter("cartao_id",cartaoPersistido.getId())
                .executeUpdate();
        logger.info("Nova transação {} associada ao cartao {}",transacao.getId(),transacao.getCartao().getId());

    }
}
