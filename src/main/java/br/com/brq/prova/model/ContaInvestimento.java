package br.com.brq.prova.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "Conta_Investimento")
public class ContaInvestimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idContaInvestimento;

	@NotEmpty
	private String numero;

	@NotEmpty
	private String agencia;

	@NotEmpty
	@Column(name = "codigo_banco")
	private String codigoBanco;

}
