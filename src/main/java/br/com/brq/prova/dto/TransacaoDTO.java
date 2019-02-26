package br.com.brq.prova.dto;

import lombok.Data;

@Data
public class TransacaoDTO {

	private String id;
	private String tipoOperacao;
	private String quantidade;
	private UsuarioDTO usuario;
	private CotacaoDTO cotacao;
	private String data;
}
