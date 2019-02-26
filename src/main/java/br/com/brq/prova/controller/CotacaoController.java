package br.com.brq.prova.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.brq.prova.dto.CotacaoDTO;
import br.com.brq.prova.mapper.CotacaoMapper;
import br.com.brq.prova.model.Cotacao;
import br.com.brq.prova.service.CotacaoService;

@RestController
@RequestMapping("api/cotacoes")
public class CotacaoController {

	@Autowired
	private CotacaoService service;

	@Autowired
	private CotacaoMapper mapper;

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public String criar(@RequestBody @Valid CotacaoDTO dto) {
		Cotacao cotacao = mapper.toObject(dto);
		return service.novo(cotacao).toString();
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CotacaoDTO> buscar() {
		List<Cotacao> cotacoes = service.buscar();
		return mapper.toDTOs(cotacoes);
	}
}
