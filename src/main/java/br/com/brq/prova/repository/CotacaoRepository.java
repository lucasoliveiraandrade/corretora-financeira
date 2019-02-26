package br.com.brq.prova.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.brq.prova.model.Cotacao;

@Repository
public interface CotacaoRepository extends CrudRepository<Cotacao, Long> {

	List<Cotacao> findAllByAcao(Long acaoId);

}
