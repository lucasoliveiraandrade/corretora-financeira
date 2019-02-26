package br.com.brq.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brq.prova.model.Cotacao;
import br.com.brq.prova.model.Transacao;
import br.com.brq.prova.model.Usuario;
import br.com.brq.prova.repository.TransacaoRepository;

@Service
public class TransacaoService {

	@Autowired
	private TransacaoRepository repository;

	@Autowired
	private CotacaoService cotacaoService;

	@Autowired
	private UsuarioService usuarioService;

	public Long novo(Transacao transacao) {

		Cotacao cotacao = cotacaoService.buscaPorId(transacao.getCotacao().getIdCotacao());

		Usuario usuario = usuarioService.buscar(transacao.getUsuario().getIdUsuario().toString());

		if (cotacao == null || usuario == null) {
			throw new RuntimeException("Transação inválida");
		}

		transacao.setCotacao(cotacao);
		transacao.setUsuario(usuario);

		return repository.save(transacao).getIdTransacao();
	}

	public List<Transacao> buscaPorUsuarioId(String usuarioId) {
		if (usuarioId == null) {
			throw new RuntimeException("Usuário inválido");
		}

		Usuario usuario = usuarioService.buscar(usuarioId);

		if (usuario == null) {
			throw new RuntimeException("Usuário inválido");
		}

		return repository.findAllByUsuario(usuario);
	}
}
