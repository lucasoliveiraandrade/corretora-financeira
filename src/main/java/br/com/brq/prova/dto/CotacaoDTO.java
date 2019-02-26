package br.com.brq.prova.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class CotacaoDTO {

	private String id;

	private AcaoDTO acao;

	@NotEmpty
	private String valor;

	@NotEmpty
	private String data;

}
