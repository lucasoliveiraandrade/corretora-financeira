package br.com.brq.prova.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.brq.prova.dto.AcaoDTO;
import br.com.brq.prova.dto.CotacaoDTO;
import br.com.brq.prova.mapper.AcaoMapper;
import br.com.brq.prova.mapper.CotacaoMapper;
import br.com.brq.prova.model.Acao;
import br.com.brq.prova.model.Cotacao;
import br.com.brq.prova.service.AcaoService;

@RestController
@RequestMapping("api/acoes")
public class AcaoController {

	@Autowired
	private AcaoService service;

	@Autowired
	private AcaoMapper mapper;

	@Autowired
	private CotacaoMapper cotacaoMapper;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public String criar(@RequestBody @Valid AcaoDTO dto) {
		Acao acao = mapper.toObject(dto);
		return service.novo(acao).toString();
	}

	@RequestMapping(value = "/{acaoId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public AcaoDTO buscar(@PathVariable @NotEmpty String acaoId) {
		Acao acao = service.buscar(acaoId);
		return mapper.toDTO(acao);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AcaoDTO> buscar() {
		List<Acao> acoes = service.buscar();
		return mapper.toDTOs(acoes);
	}

	@RequestMapping(value = "/{acaoId}/cotacoes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CotacaoDTO> buscarCotacoesPorAcaoId(@PathVariable @NotEmpty String acaoId) {
		List<Cotacao> cotacoes = service.buscarCotacoesPorAcaoId(Long.valueOf(acaoId));
		return cotacaoMapper.toDTOs(cotacoes);
	}
}
