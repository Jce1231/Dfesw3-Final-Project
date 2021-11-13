package uk.jordanellis.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uk.jordanellis.domain.Leaderboard;
import uk.jordanellis.service.LeaderboardService;

@RestController
@RequestMapping("/leaderboard")
public class leaderBController {
	private LeaderboardService service;

	public leaderBController(LeaderboardService service) {
		super();
		this.service = service;
	}

	@GetMapping("/getAll")
	public List<Leaderboard> getAllLeaders() {
		return this.service.getAllLeaders();
	}

	@GetMapping("/getByChar/{id}")
	public Leaderboard getOne(@PathVariable int id) {
		return this.service.fight(id);
	}
}
