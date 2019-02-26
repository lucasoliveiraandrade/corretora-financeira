package br.com.brq.prova.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brq.prova.model.Acao;
import br.com.brq.prova.model.Cotacao;
import br.com.brq.prova.repository.CotacaoRepository;

@Service
public class CotacaoService {

	@Autowired
	private CotacaoRepository repository;

	@Autowired
	private AcaoService acaoService;

	public Long novo(Cotacao cotacao) {

		if (cotacao.getAcao() == null) {
			throw new RuntimeException("Cotação inválida");
		}

		Acao acao = acaoService.buscar(cotacao.getAcao().getIdAcao().toString());

		if (acao == null) {
			throw new RuntimeException("Cotação inválida");
		}

		cotacao.setAcao(acao);

		return repository.save(cotacao).getIdCotacao();
	}

	public List<Cotacao> buscaPorAcaoId(Long acaoId) {
		return repository.findAllByAcao(acaoId);
	}

	public Cotacao buscaPorId(Long cotacaoId) {
		if (cotacaoId == null) {
			throw new RuntimeException("Cotação inválida");
		}

		return repository.findById(cotacaoId).orElse(null);
	}

	public List<Cotacao> buscar() {
		List<Cotacao> result = new ArrayList<>();
		repository.findAll().forEach(result::add);
		return result;
	}
}
