package br.com.brq.prova.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.brq.prova.dto.AcaoDTO;
import br.com.brq.prova.model.Acao;

@Component
public class AcaoMapper {

	@Autowired
	private ModelMapper modelMapper;

	public AcaoDTO toDTO(Acao acao) {
		return modelMapper.map(acao, AcaoDTO.class);
	}

	public Acao toObject(AcaoDTO dto) {
		return modelMapper.map(dto, Acao.class);
	}

	public List<AcaoDTO> toDTOs(List<Acao> acoes) {
		return acoes.stream().map(this::toDTO).collect(Collectors.toList());
	}
}
