package br.com.brq.prova.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.brq.prova.dto.UsuarioDTO;
import br.com.brq.prova.model.Usuario;

@Component
public class UsuarioMapper {

	@Autowired
	private ModelMapper modelMapper;

	public UsuarioDTO toDTO(Usuario usuario) {
		return modelMapper.map(usuario, UsuarioDTO.class);
	}

	public Usuario toObject(UsuarioDTO dto) {
		return modelMapper.map(dto, Usuario.class);
	}

	public List<UsuarioDTO> toDTOs(List<Usuario> usuarios) {
		return usuarios.stream().map(this::toDTO).collect(Collectors.toList());
	}
}
