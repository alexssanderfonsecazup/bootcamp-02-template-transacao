package br.com.bootcamp.zup.transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/transacoes")
public class ConsultaTransacoesController {

    @Autowired
    private TransacaoClient transacaoClient;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Value("${transacao.idcartao.estimular}")
    private  String cartoesEstimulado;

    @Value("${transacao.email.logado}")
    private  String emailUsuarioLogado;

    @GetMapping
    public ResponseEntity <?> consultaTransacoes(){
        List<Transacao> transacoes = transacaoRepository.findAll();
        return ResponseEntity.ok(TransacaoResponse.toList(transacoes));
    }

    @PostMapping
    public void subscreverEnvioTransacao(){
        transacaoClient.estimulaTransacao( Map.of("id", cartoesEstimulado,"email",emailUsuarioLogado));
    }

    public void desinscreverEnvioTransacao(){
    }


}
