package uk.jordanellis.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
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

import uk.jordanellis.domain.Users;
import uk.jordanellis.dto.UsersDTO;
import uk.jordanellis.dto.UsersNoCharactDTO;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:user-schema.sql", "classpath:char-schema.sql",
		"classpath:user-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class UserIntegrationTest {
	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private ModelMapper modMap;

	@Test
	void testCreate() throws Exception {
		Users requestBody = new Users("Jordan");
		String requestAsJson = this.mapper.writeValueAsString(requestBody);
		RequestBuilder request = post("/user/create").contentType(MediaType.APPLICATION_JSON).content(requestAsJson);

		Users responseBody = new Users(2, "Jordan");
		String responseAsJson = this.mapper.writeValueAsString(responseBody);
		ResultMatcher checkBody = content().json(responseAsJson);
		this.mvc.perform(request).andExpect(status().isCreated()).andExpect(checkBody);
	}

	@Test
	void testGet() throws Exception {
		RequestBuilder request = get("/user/get/1");
		Users responseBody = new Users(1, "System Generated");
		String responseAsJson = this.mapper.writeValueAsString(responseBody);

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(responseAsJson);
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGetAll() throws Exception {
		RequestBuilder request = get("/user/getUsers");
		Users responseBody = new Users(1, "System Generated");
		List<UsersNoCharactDTO> users = List.of(this.modMap.map(responseBody, UsersNoCharactDTO.class));
		String responseAsJson = this.mapper.writeValueAsString(users);

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(responseAsJson);
		System.out.println(this.mvc.perform(request));
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testUpdate() throws Exception {
		Users requestBody = new Users("Bobert");
		String requestAsJson = this.mapper.writeValueAsString(requestBody);
		RequestBuilder request = put("/user/update/1").contentType(MediaType.APPLICATION_JSON).content(requestAsJson);
		Users responseBody = new Users(1, "Bobert");
		String responseAsJSON = this.mapper.writeValueAsString(responseBody);

		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(responseAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testDelete() throws Exception {
		RequestBuilder request = delete("/user/delete/1");
		ResultMatcher checkStatus = status().isNoContent();
		this.mvc.perform(request).andExpect(checkStatus);
	}

	@Test
	void testDeleteError() throws Exception {
		RequestBuilder request = delete("/user/delete/0");
		ResultMatcher checkStatus = status().isInternalServerError();
		this.mvc.perform(request).andExpect(checkStatus);
	}

	@Test
	void getUserChar() throws Exception {
		RequestBuilder request = get("/user/getUserChar");
		Users responseBody = new Users(1, "System Generated");
		List<UsersDTO> users = List.of(this.modMap.map(responseBody, UsersDTO.class));
		String responseAsJson = this.mapper.writeValueAsString(users);

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(responseAsJson);
		System.out.println(this.mvc.perform(request));
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

}
