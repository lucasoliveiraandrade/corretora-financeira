package br.com.brq.prova.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class TokenUtil {

	public static String geraToken() {
		UUID uuid = UUID.randomUUID();

		return uuid.toString();
	}
}
