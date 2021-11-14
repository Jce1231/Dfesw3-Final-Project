package uk.jordanellis.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import uk.jordanellis.domain.Charact;
import uk.jordanellis.domain.Leaderboard;
import uk.jordanellis.domain.Users;
import uk.jordanellis.dto.LBDto;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:user-schema.sql", "classpath:char-schema.sql", "classpath:leaderboard-schema.sql",
		"classpath:user-data.sql", "classpath:char-data.sql",
		"classpath:leaderboard-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class LeaderboardIntegrationTest {
	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private ModelMapper modMap;

	private Leaderboard leader;

	@BeforeEach
	void setup() {
		Users user = new Users(1, "System Generated");
		Charact charact = new Charact(2, 5, 6, 9, 5, user);
		leader = new Leaderboard(charact, 0, 0, 1);
	}

	@Test
	void testGetAll() throws Exception {
		RequestBuilder request = get("/leaderboard/getAll");

		List<LBDto> leaders = List.of(this.modMap.map(leader, LBDto.class));
		String responseAsJson = this.mapper.writeValueAsString(leaders);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(responseAsJson);
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGetById() throws Exception {
		RequestBuilder request = get("/leaderboard/get/1");
		LBDto leaderdt = this.modMap.map(leader, LBDto.class);
		String responseAsJson = this.mapper.writeValueAsString(leaderdt);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(responseAsJson);
		this.mvc.perform(request).andExpect(checkBody).andExpect(checkStatus);
	}

	@Test
	void testGetByCharCreateLB() throws Exception {
		RequestBuilder request = get("/leaderboard/getByChar/1");

		Users user = new Users(1, "System Generated");
		Charact charact = new Charact(1, 5, 6, 9, 5, user);
		leader = new Leaderboard(charact, 1, 0, 2);
		LBDto leaderdt = this.modMap.map(leader, LBDto.class);
		String responseAsJson = this.mapper.writeValueAsString(leaderdt);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(responseAsJson);
		this.mvc.perform(request).andExpect(checkBody).andExpect(checkStatus);
	}

	@Test
	void testGetByChar() throws Exception {
		RequestBuilder request = get("/leaderboard/getByChar/2");

		LBDto leaderdt = this.modMap.map(leader, LBDto.class);
		String responseAsJson = this.mapper.writeValueAsString(leaderdt);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(responseAsJson);
		this.mvc.perform(request).andExpect(checkBody).andExpect(checkStatus);
	}
}
