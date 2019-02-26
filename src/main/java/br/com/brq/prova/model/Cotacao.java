package br.com.brq.prova.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Cotacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idCotacao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCotacao", nullable = false)
	private Acao acao;

	private Long valor;

	private LocalDate data;
}
