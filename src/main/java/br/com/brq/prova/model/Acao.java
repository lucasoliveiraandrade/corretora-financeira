package br.com.brq.prova.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
public class Acao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idAcao;

	@NotEmpty
	private String descricao;

	@OneToMany(mappedBy = "acao", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Cotacao> cotacoes;
}
