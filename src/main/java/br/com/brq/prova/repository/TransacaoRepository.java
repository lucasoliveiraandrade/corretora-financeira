package br.com.brq.prova.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.brq.prova.model.Transacao;
import br.com.brq.prova.model.Usuario;

@Repository
public interface TransacaoRepository extends CrudRepository<Transacao, Long> {

	List<Transacao> findAllByUsuario(Usuario usuario);

}
