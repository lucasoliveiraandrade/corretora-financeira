package br.com.brq.prova.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.brq.prova.dto.TransacaoDTO;
import br.com.brq.prova.mapper.TransacaoMapper;
import br.com.brq.prova.model.Transacao;
import br.com.brq.prova.service.TransacaoService;

@RestController
@RequestMapping("api/transacoes")
public class TransacaoController {

	@Autowired
	private TransacaoService service;

	@Autowired
	private TransacaoMapper mapper;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public String criaTransacao(@RequestBody @Valid TransacaoDTO dto) {
		Transacao transacao = mapper.toObject(dto);
		return service.novo(transacao).toString();
	}
}