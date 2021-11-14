package uk.jordanellis.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uk.jordanellis.dto.LBDto;
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
	public List<LBDto> getAllLeaders() {
		return this.service.getAllLeaders();
	}

	@GetMapping("/get/{id}")
	public LBDto getById(@PathVariable int id) {
		return this.service.getLeader(id);
	}

	@GetMapping("/getByChar/{id}")
	public LBDto getOne(@PathVariable int id) {
		return this.service.fight(id);
	}
}
