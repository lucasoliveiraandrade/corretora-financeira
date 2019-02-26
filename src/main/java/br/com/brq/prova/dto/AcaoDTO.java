package br.com.brq.prova.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class AcaoDTO {

	private String id;

	@NotEmpty
	private String descricao;

	// private List<CotacaoDTO> cotacoes;
}
