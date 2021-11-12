package uk.jordanellis.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import uk.jordanellis.domain.Leaderboard;
import uk.jordanellis.service.LeaderboardService;

@RestController
public class leaderBController {
	private LeaderboardService service;

	public leaderBController(LeaderboardService service) {
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

	@PutMapping("/leaderboard/init")
	public String initial() {
		this.service.initialise();
		return "Successfully initialised";
	}
}
