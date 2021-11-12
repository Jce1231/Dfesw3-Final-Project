package uk.jordanellis.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import uk.jordanellis.domain.Leaderboard;
import uk.jordanellis.service.LeaderboardController;

@RestController
public class leaderBController {
	private LeaderboardController service;

	public leaderBController(LeaderboardController service) {
		super();
		this.service = service;
	}

	@GetMapping("/leaderboard/getAll")
	public List<Leaderboard> getAllLeaders() {
		return this.service.getAllLeaders();
	}

	@GetMapping("/leaderboard/calculate")
	public String calLeader() {
		this.service.fightLoop();
		return "Calculating leaderboard";
	}
}
