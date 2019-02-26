package br.com.brq.prova.integrationtest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = br.com.brq.prova.Configuracao.class, webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.yml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioControllerTest {

	private static final String REQUEST_BODY_POST = "{ \"nome\":\"lucas\", \"cpf\":\"123.123.123-12\", \"usuario\":\"lucas123\", \"senha\":\"12345\", \"email\":\"lucas.andrade999@gmail.com\" }";

	@Autowired
	protected MockMvc mvc;

	@Test
	public void test001_deveCriarNovoUsuario() throws Exception {
		mvc.perform(post("/api/usuarios").content(REQUEST_BODY_POST).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}

	@Test
	public void test002_deveBuscarTodosUsuarios() throws Exception {
		mvc.perform(get("/api/usuarios").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
}
