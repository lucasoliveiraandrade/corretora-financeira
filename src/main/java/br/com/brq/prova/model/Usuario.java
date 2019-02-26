package br.com.brq.prova.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import br.com.brq.prova.enumeration.UsuarioStatus;
import lombok.Data;

@Data
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idUsuario;

	@NotEmpty
	private String cpf;

	@NotEmpty
	@Column(name = "codigo_bovespa")
	private String codigoBovespa;

	@NotEmpty
	private String nome;

	@Email
	private String email;

	@NotEmpty
	private String usuario;

	@NotEmpty
	private String senha;

	private String tokenAtivacao;

	@OneToOne
	private ContaInvestimento conta;

	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	// private List<Transacao> comprasVendas;

	@Enumerated(EnumType.STRING)
	private UsuarioStatus status;

}
