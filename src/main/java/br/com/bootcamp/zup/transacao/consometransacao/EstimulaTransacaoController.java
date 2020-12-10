package br.com.bootcamp.zup.transacao.consometransacao;

import br.com.bootcamp.zup.transacao.integracao.TransacaoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Map;

@RestController
@RequestMapping("/estimulos")
public class EstimulaTransacaoController {


    @Autowired
    private TransacaoClient transacaoClient;

    @PersistenceContext
    EntityManager entityManager;

    @Value("${transacao.idcartao.estimular}")
    private  String cartoesEstimulado;

    @Value("${transacao.email.logado}")
    private  String emailUsuarioLogado;


    @PostMapping
    public void subscreverEnvioTransacao(){
        transacaoClient.estimulaTransacao( Map.of("id", cartoesEstimulado,"email",emailUsuarioLogado));
    }

    public void desinscreverEnvioTransacao(){
    }



}
