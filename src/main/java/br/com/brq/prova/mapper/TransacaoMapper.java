package br.com.brq.prova.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.brq.prova.dto.CotacaoDTO;
import br.com.brq.prova.dto.TransacaoDTO;
import br.com.brq.prova.dto.UsuarioDTO;
import br.com.brq.prova.model.Transacao;

@Component
public class TransacaoMapper {

	@Autowired
	private ModelMapper modelMapper;

	public TransacaoDTO toDTO(Transacao transacao) {

		CotacaoDTO cotacaoDTO = new CotacaoDTO();
		cotacaoDTO.setValor(transacao.getCotacao().getValor().toString());

		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setNome(transacao.getUsuario().getNome());

		TransacaoDTO dto = new TransacaoDTO();
		dto.setId(transacao.getIdTransacao().toString());
		dto.setQuantidade(transacao.getQuantidade().toString());
		dto.setTipoOperacao(transacao.getTipoOperacao().toString());
		dto.setCotacao(cotacaoDTO);
		dto.setUsuario(usuarioDTO);
		dto.setData(transacao.getData().toString()); // TODO: formatar data

		return dto;
	}

	public Transacao toObject(TransacaoDTO dto) {
		return modelMapper.map(dto, Transacao.class);
	}

	public List<TransacaoDTO> toDTOs(List<Transacao> transacoes) {
		return transacoes.stream().map(this::toDTO).collect(Collectors.toList());
	}
}
