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

import br.com.brq.prova.enumeration.TipoOperacao;
import lombok.Data;

@Entity
@Data
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idTransacao;

	@Column(name = "tipo_operacao")
	private TipoOperacao tipoOperacao;

	@Column(name = "data_operacao")
	private LocalDate data;

	private Long quantidade;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCotacao", nullable = false)
	private Cotacao cotacao;

}
