package br.com.brq.prova.integrationtest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
@SpringBootTest(classes = br.com.brq.prova.Configuration.class, webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.yml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AcaoControllerTest {

	private static final String REQUEST_BODY_POST = "{ \"descricao\":\"Ação 001\" }";

	@Autowired
	protected MockMvc mvc;

	@Test
	public void test001_deveCriarNovaAcao() throws Exception {
		mvc.perform(post("/api/acoes").content(REQUEST_BODY_POST).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}

	@Test
	public void test002_deveBuscarTodasAcoes() throws Exception {
		mvc.perform(get("/api/acoes").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
}
