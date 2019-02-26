package br.com.brq.prova.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brq.prova.model.Acao;
import br.com.brq.prova.model.Cotacao;
import br.com.brq.prova.repository.AcaoRepository;

@Service
public class AcaoService {

	@Autowired
	private AcaoRepository repository;

	@Autowired
	private CotacaoService cotacaoService;

	public Long novo(Acao acao) {

		Acao acaoDB = repository.save(acao);

		return acaoDB.getIdAcao();
	}

	public Acao buscar(String acaoId) {
		Long acaoIdLong = Long.valueOf(acaoId);

		Optional<Acao> acaoDB = repository.findById(acaoIdLong);

		if (acaoDB.isPresent()) {
			return acaoDB.get();
		}

		throw new RuntimeException("Ação não encontrada");
	}

	public List<Acao> buscar() {
		List<Acao> result = new ArrayList<>();
		repository.findAll().forEach(result::add);
		return result;
	}

	public List<Cotacao> buscarCotacoesPorAcaoId(Long acaoId) {
		return cotacaoService.buscaPorAcaoId(acaoId);
	}
}
