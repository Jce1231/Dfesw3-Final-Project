package uk.jordanellis.rest;

import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@Sql(scripts = { "classpath:user-schema.sql", "classpath:char-schema.sql", "classpath:leaderboard-schema.sql",
		"classpath:user-data.sql", "classpath:char-data.sql",
		"classpath:leaderboard-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class LeaderboardIntegrationTest {

}
