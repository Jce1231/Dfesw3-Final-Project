package uk.jordanellis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.jordanellis.domain.Charact;
import uk.jordanellis.domain.Leaderboard;
import uk.jordanellis.dto.LBDto;
import uk.jordanellis.exceptions.LeaderboardNotFoundException;
import uk.jordanellis.repo.LeaderboardRepo;

@Service
public class LeaderboardService {

	private LeaderboardRepo repo;
	@Autowired
	private CharactService service;
	private ModelMapper mapper;
	private int dbSize;

	/**
	 * @param repo
	 * @param mapper
	 */
	public LeaderboardService(LeaderboardRepo repo, ModelMapper mapper, CharactService service) {
		super();
		this.repo = repo;
		this.mapper = mapper;
		this.service = service;
		this.dbSize = this.service.getCharacts().size();
	}

	public LBDto mapToDto(Leaderboard leader) {
		return this.mapper.map(leader, LBDto.class);
	}

	public LBDto getLeader(Integer id) {
		return this.mapToDto(this.repo.findById(id).orElseThrow(
				() -> new LeaderboardNotFoundException("A leaderboard entry could not be found with ID :" + id)));
	}

	public List<LBDto> getAllLeaders() {
		return this.repo.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
	}

	public LBDto getByCharact(Charact charac) {
		return this.mapToDto(this.repo.findByAttacker(charac));
	}

//	public void fightLoop() {
//		
//
////		ArrayList<Leaderboard> leaderboard = new ArrayList<>();
////		leaderboard = (ArrayList<Leaderboard>) this.repo.findAll();
////		for (int i = 0; i <= leaderboard.size() - 1; i++) {
////			Leaderboard fighter = leaderboard.get(i);
////			for (int j = i; j <= leaderboard.size() - 1; j++) {
////				if (i != j) {
////					Leaderboard defender = leaderboard.get(j);
////					fight(fighter, defender);
////					System.out.println("Loop I: " + i + " Loop J: " + j);
////					leaderboard.set(j, defender);
////
////				}
////			}
////			leaderboard.set(i, fighter);
////		}
////		this.repo.saveAll(leaderboard);
//	}
	private void checkDb() {
		if (this.dbSize != this.service.getCharacts().size()) {
			Charact defender;
			for (int i = this.dbSize + 1; i <= this.service.getCharacts().size(); i++) {
				defender = this.service.getChar(i);
				for (Leaderboard L : this.repo.findAll()) {
					if (fightt(L.getAttacker(), defender)) {
						L.addWin();
						;
					} else {
						L.addLoss();

					}
					this.repo.save(L);
				}
			}
		}
		this.dbSize = this.service.getCharacts().size();
	}

	public LBDto fight(int id) {
		checkDb();
		Charact fighter = this.service.getChar(id);
		if (this.repo.findByAttacker(fighter) != null) {
			return getByCharact(fighter);
		} else {
			Leaderboard fighting = new Leaderboard(fighter, 0, 0);
			List<Charact> defenders = new ArrayList<>();
			defenders.addAll(this.service.getChars());
			System.out.println(defenders.size());
			for (int i = 0; i <= defenders.size() - 1; i++) {
				if (fighter == defenders.get(i)) {
				} else {
					if (fightt(fighter, defenders.get(i))) {
						fighting.addWin();
					} else {
						fighting.addLoss();

					}
				}
			}
			return this.mapToDto(this.repo.save(fighting));
		}
	}

	public boolean fightt(Charact fighter, Charact defender) {

		while (fighter.getHealth() >= 1 && defender.getHealth() >= 1) {
			if (fighter.getSpeed() >= defender.getSpeed()) {
				fighter.attack(defender);
				if (defender.getHealth() >= 1) {
					defender.attack(fighter);
				} else {
				}
			} else {
				defender.attack(fighter);
				if (fighter.getHealth() >= 1) {
					fighter.attack(defender);
				} else {
				}
			}
		}
		if (defender.getHealth() > fighter.getHealth()) {
			fighter.calcHp();
			defender.calcHp();
			return false;
		} else {
			fighter.calcHp();
			defender.calcHp();
			return true;
		}

	}
}
