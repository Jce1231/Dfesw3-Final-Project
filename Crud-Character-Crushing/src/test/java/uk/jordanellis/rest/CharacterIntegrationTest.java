package uk.jordanellis.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import uk.jordanellis.domain.Charact;
import uk.jordanellis.domain.Users;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:user-schema.sql", "classpath:char-schema.sql", "classpath:user-data.sql",
		"classpath:char-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class CharacterIntegrationTest {
	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Users user = new Users(2, "Jordan");
		Charact requestBody = new Charact(5, 10, 5, 5, user);
		String requestAsJson = this.mapper.writeValueAsString(requestBody);
		RequestBuilder request = post("/char/create").contentType(MediaType.APPLICATION_JSON).content(requestAsJson);

		Charact responseBody = new Charact(2, 5, 10, 5, 5, user);
		String responseAsJson = this.mapper.writeValueAsString(responseBody);
		ResultMatcher checkBody = content().json(responseAsJson);
		this.mvc.perform(request).andExpect(status().isCreated()).andExpect(checkBody);
	}

	@Test
	void testGet() throws Exception {
		Users user = new Users(1, "System Generated");
		RequestBuilder request = get("/char/get/1");
		Charact responseBody = new Charact(1, 5, 5, 10, 5, user);
		String responseAsJson = this.mapper.writeValueAsString(responseBody);

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(responseAsJson);
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGetAll() throws Exception {
		RequestBuilder request = get("/char/getAll");
		Users user = new Users(1, "System Generated");
		Charact responseBody = new Charact(1, 5, 5, 10, 5, user);
		List<Charact> characts = List.of(responseBody);
		String responseAsJson = this.mapper.writeValueAsString(characts);

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(responseAsJson);
		System.out.println(this.mvc.perform(request));
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testUpdate() throws Exception {
		Users user = new Users(1, "System Generated");
		Charact requestBody = new Charact(10, 5, 5, 5, user);
		String requestAsJson = this.mapper.writeValueAsString(requestBody);
		RequestBuilder request = put("/char/update/1").contentType(MediaType.APPLICATION_JSON).content(requestAsJson);
		Charact responseBody = new Charact(1, 10, 5, 5, 5, user);
		String responseAsJSON = this.mapper.writeValueAsString(responseBody);

		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(responseAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testDelete() throws Exception {
		RequestBuilder request = delete("/char/delete/1");
		ResultMatcher checkStatus = status().isNoContent();
		this.mvc.perform(request).andExpect(checkStatus);
	}

	@Test
	void testDeleteError() throws Exception {
		RequestBuilder request = delete("/char/delete/0");
		ResultMatcher checkStatus = status().isInternalServerError();
		this.mvc.perform(request).andExpect(checkStatus);
	}

}
