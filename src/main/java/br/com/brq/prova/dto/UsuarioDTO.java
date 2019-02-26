package br.com.brq.prova.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class UsuarioDTO {

	private String id;
	private String nome;

	@NotEmpty
	private String cpf;
	private String usuario;
	private String senha;
	private String codigoBovespa;

	@NotEmpty
	@Email
	private String email;
	private String status;
}
