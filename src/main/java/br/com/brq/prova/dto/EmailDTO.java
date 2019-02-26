package br.com.brq.prova.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class EmailDTO {

	@NotEmpty
	private String para;

	@NotEmpty
	private String titulo;

	@NotEmpty
	private String corpo;

	private String contentType;
}
