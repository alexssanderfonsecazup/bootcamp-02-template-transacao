package br.com.bootcamp.zup.transacao.consultatransacao;

import br.com.bootcamp.zup.transacao.consometransacao.Cartao;
import br.com.bootcamp.zup.transacao.integracao.TransacaoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/transacoes")
public class ConsultaTransacoesController {

    @Autowired
    private TransacaoClient transacaoClient;

    @PersistenceContext
    EntityManager entityManager;

    @Value("${transacao.idcartao.estimular}")
    private  String cartoesEstimulado;

    @Value("${transacao.email.logado}")
    private  String emailUsuarioLogado;

    @GetMapping("/{idCartao}")
    public ResponseEntity <?> consultaTransacoes(@PathVariable UUID idCartao){

        Cartao cartao = entityManager.find(Cartao.class,idCartao);
        if(cartao == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Cartão nao encontrado");
        }
        List<Transacao> transacoes = entityManager.createQuery("SELECT t FROM Transacao t ORDER BY t.efetivadaEm ASC WHERE t.id = :idCartao",Transacao.class)
                .setParameter("idCartao",idCartao)
                .setMaxResults(10).getResultList();
        return ResponseEntity.ok(TransacaoResponse.toList(transacoes));
    }




}