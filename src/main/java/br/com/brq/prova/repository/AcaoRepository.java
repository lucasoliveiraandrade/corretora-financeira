package br.com.brq.prova.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.brq.prova.model.Acao;

@Repository
public interface AcaoRepository extends CrudRepository<Acao, Long> {

}
