package br.com.bootcamp.zup.transacao.consometransacao;

import br.com.bootcamp.zup.transacao.consultatransacao.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao,String> { }
