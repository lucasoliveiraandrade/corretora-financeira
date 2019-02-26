package br.com.brq.prova.integrationtest.controller;

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
public class TransacaoControllerTest {

	private static final String REQUEST_BODY_POST = "{\n" + 
			"	\"tipoOperacao\":\"COMPRA\",\n" + 
			"	\"quantidade\": \"1\",\n" + 
			"	\"data\": \"2000-09-27\", \n" + 
			"	\"usuario\": {\n" + 
			"        \"id\": \"14\"\n" + 
			"    },\n" + 
			"	\"cotacao\": {\n" + 
			"		\"id\": \"1\",\n" + 
			"		\"data\": \"2000-09-27\",\n" + 
			"		\"valor\": \"123\"\n" + 
			"	}\n" + 
			"}";
	
	@Autowired
	protected MockMvc mvc;

	@Test
	public void test001_deveCriarNovaTransacao() throws Exception {
		mvc.perform(post("/api/transacoes").content(REQUEST_BODY_POST).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}
}
