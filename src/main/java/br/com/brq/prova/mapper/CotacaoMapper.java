package br.com.brq.prova.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.brq.prova.dto.CotacaoDTO;
import br.com.brq.prova.model.Cotacao;

@Component
public class CotacaoMapper {

	@Autowired
	private ModelMapper modelMapper;

	public CotacaoDTO toDTO(Cotacao cotacao) {
		CotacaoDTO cotacaoDTO = new CotacaoDTO();
		cotacaoDTO.setId(cotacao.getIdCotacao().toString());
		cotacaoDTO.setValor(cotacao.getValor().toString());
		cotacaoDTO.setData(cotacao.getData().toString());

		return cotacaoDTO;
	}

	public Cotacao toObject(CotacaoDTO dto) {
		return modelMapper.map(dto, Cotacao.class);
	}

	public List<CotacaoDTO> toDTOs(List<Cotacao> cotacoes) {
		return cotacoes.stream().map(this::toDTO).collect(Collectors.toList());
	}
}
