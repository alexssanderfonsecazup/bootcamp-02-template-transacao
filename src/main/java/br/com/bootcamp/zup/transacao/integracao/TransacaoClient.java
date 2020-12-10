package br.com.bootcamp.zup.transacao.integracao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(url = "http://localhost:7777/api/cartoes",name = "cartoes")
public interface TransacaoClient {

    @PostMapping
    void estimulaTransacao(@RequestBody Map<String,Object> estimuloTransacao);


}
