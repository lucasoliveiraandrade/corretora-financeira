package br.com.brq.prova.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brq.prova.enumeration.UsuarioStatus;
import br.com.brq.prova.model.Usuario;
import br.com.brq.prova.repository.UsuarioRepository;
import br.com.brq.prova.util.TokenUtil;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Long criarNovo(Usuario usuario) {

		usuario.setStatus(UsuarioStatus.EM_APROVACAO);
		usuario.setCodigoBovespa("123"); // fornecido pela corretora
		usuario.setTokenAtivacao(TokenUtil.geraToken());

		Usuario userResult = repository.save(usuario);

		return userResult.getIdUsuario();
	}

	public Long atualizaUsuario(Usuario usuario) {

		if (usuario.getIdUsuario() == null) {
			throw new RuntimeException("Usuário inválido");
		}

		if (!repository.existsById(usuario.getIdUsuario())) {
			throw new RuntimeException("Usuário não encontrado");
		}

		Usuario usuarioDB = repository.findById(usuario.getIdUsuario()).get();

		usuarioDB.setNome(usuario.getNome());
		usuarioDB.setCpf(usuario.getCpf());
		usuarioDB.setEmail(usuario.getEmail());
		usuarioDB.setCodigoBovespa(usuario.getCodigoBovespa());
		usuarioDB.setSenha(usuario.getSenha());
		repository.save(usuarioDB);

		return usuarioDB.getIdUsuario();
	}

	public void deletaUsuario(String usuarioId) {
		if (usuarioId == null) {
			throw new RuntimeException("Usuário inválido");
		}

		Long usuarioIdLong = Long.valueOf(usuarioId);

		if (!repository.existsById(usuarioIdLong)) {
			throw new RuntimeException("Usuário não encontrado");
		}

		Usuario usuarioDB = repository.findById(usuarioIdLong).get();
		usuarioDB.setStatus(UsuarioStatus.INATIVO);

		repository.save(usuarioDB);
	}

	public Usuario buscar(String usuarioId) {

		if (usuarioId == null) {
			throw new RuntimeException("Usuário inválido");
		}

		Long usuarioIdLong = Long.valueOf(usuarioId);

		if (!repository.existsById(usuarioIdLong)) {
			throw new RuntimeException("Usuário não encontrado");
		}

		return repository.findById(usuarioIdLong).get();
	}

	public List<Usuario> buscar() {
		List<Usuario> result = new ArrayList<>();
		repository.findAll().forEach(result::add);
		return result;
	}

	public Usuario ativaUsuario(String token) {
		Usuario usuario = repository.findByTokenAtivacao(token)
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

		usuario.setStatus(UsuarioStatus.ATIVO);
		repository.save(usuario);

		return usuario;
	}
}
