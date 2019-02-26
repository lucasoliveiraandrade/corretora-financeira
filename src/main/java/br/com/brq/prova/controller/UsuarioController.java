package br.com.brq.prova.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.brq.prova.dto.TransacaoDTO;
import br.com.brq.prova.dto.UsuarioDTO;
import br.com.brq.prova.mapper.TransacaoMapper;
import br.com.brq.prova.mapper.UsuarioMapper;
import br.com.brq.prova.model.Transacao;
import br.com.brq.prova.model.Usuario;
import br.com.brq.prova.service.EmailService;
import br.com.brq.prova.service.TransacaoService;
import br.com.brq.prova.service.UsuarioService;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@Autowired
	private UsuarioMapper mapper;

	@Autowired
	private EmailService emailService;

	@Autowired
	private TransacaoService transacaoService;

	@Autowired
	private TransacaoMapper transacaoMapper;

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public String criar(@RequestBody @Valid UsuarioDTO dto) throws AddressException, MessagingException {
		Usuario usuario = mapper.toObject(dto);
		String usuarioCriadoId = service.criarNovo(usuario).toString();
		emailService.enviar(usuario);
		return usuarioCriadoId;
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String alterar(@RequestBody @Valid UsuarioDTO dto) {
		Usuario usuario = mapper.toObject(dto);
		return service.atualizaUsuario(usuario).toString();
	}

	@RequestMapping(value = "/{usuarioId}", method = RequestMethod.DELETE)
	public String deletar(@PathVariable @NotEmpty String usuarioId) {
		service.deletaUsuario(usuarioId);
		return usuarioId;
	}

	@RequestMapping(value = "/{usuarioId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UsuarioDTO buscar(@PathVariable @NotEmpty String usuarioId) {
		Usuario usuario = service.buscar(usuarioId);
		return mapper.toDTO(usuario);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UsuarioDTO> buscar() {
		List<Usuario> usuarios = service.buscar();
		return mapper.toDTOs(usuarios);
	}

	@RequestMapping(value = "/ativacao", method = RequestMethod.GET)
	public String ativarUsuario(@RequestParam(name = "token", required = true) String token)
			throws AddressException, MessagingException {
		Usuario usuario = service.ativaUsuario(token);
		emailService.enviar(usuario);
		return usuario.getIdUsuario().toString();
	}

	@CrossOrigin
	@RequestMapping(value = "/{usuarioId}/carteira", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TransacaoDTO> buscaCarteiraInvestimento(@PathVariable @NotEmpty String usuarioId) {
		List<Transacao> transacoes = transacaoService.buscaPorUsuarioId(usuarioId);
		return transacaoMapper.toDTOs(transacoes);
	}
}
