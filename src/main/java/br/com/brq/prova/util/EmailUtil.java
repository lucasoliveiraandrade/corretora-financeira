package br.com.brq.prova.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.brq.prova.dto.EmailDTO;
import br.com.brq.prova.model.Usuario;

@Component
public class EmailUtil {

	@Value("${email.localhost}")
	private String localhost;

	public EmailDTO criaEmailDTO(Usuario usuario) {

		switch (usuario.getStatus()) {
			case EM_APROVACAO:
				return criaEmailAtivacao(usuario);

			case ATIVO:
				return criaEmailConfirmacao(usuario);

			default:
				return null; // TODO
			}
	}

	private EmailDTO criaEmailAtivacao(Usuario usuario) {

		StringBuilder sb = new StringBuilder();
		sb.append("Parabens! Seja bem vindo a corretora. ");
		sb.append("Clique no link a seguir para ativar seu cadastro. ");
		sb.append(localhost + "api/usuarios/ativacao?token=" + usuario.getTokenAtivacao());

		EmailDTO dto = new EmailDTO();
		dto.setCorpo(sb.toString());
		dto.setPara(usuario.getEmail());
		dto.setTitulo("Confirmação Cadastro");
		dto.setContentType("text/plain");

		return dto;
	}

	private EmailDTO criaEmailConfirmacao(Usuario usuario) {
		EmailDTO dto = new EmailDTO();
		dto.setCorpo("Sua conta na corretora foi confirmada. Acesse já.");
		dto.setPara(usuario.getEmail());
		dto.setTitulo("Oba! Conta ativada com sucesso!");
		dto.setContentType("text/plain");

		return dto;
	}
}
