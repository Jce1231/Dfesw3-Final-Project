package uk.jordanellis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.jordanellis.domain.Charact;
import uk.jordanellis.domain.Leaderboard;
import uk.jordanellis.exceptions.LeaderboardNotFoundException;
import uk.jordanellis.repo.LeaderboardRepo;

@Service
public class LeaderboardService {

	private LeaderboardRepo repo;
	@Autowired
	private CharactService service;

	/**
	 * @param repo
	 */
	public LeaderboardService(LeaderboardRepo repo) {
		super();
		this.repo = repo;
	}

	public Leaderboard getLeader(Integer id) {
		return this.repo.findById(id).orElseThrow(
				() -> new LeaderboardNotFoundException("A leaderboard entry could not be found with ID :" + id));
	}

	public List<Leaderboard> getAllLeaders() {
		return this.repo.findAll();
	}

	public Leaderboard getByCharact(Charact charac) {
		return this.repo.findByAttacker(charac);
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

	public Leaderboard fight(int id) {
		Charact fighter = this.service.getCharact(id);
		if (this.repo.findByAttacker(fighter) != null) {
			return this.repo.findByAttacker(fighter);
		} else {
			Leaderboard fighting = new Leaderboard(fighter, 0, 0);
			List<Charact> defenders = new ArrayList<>();
			defenders.addAll(this.service.getCharacts());
			System.out.println(defenders.size());
			for (int i = 0; i <= defenders.size() - 1; i++) {
				if (fighter == defenders.get(i)) {
				} else {
					Charact defender = defenders.get(i);
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
						fighting.addLoss();
					} else {
						fighting.addWin();
					}

					fighter.calcHp();
					defender.calcHp();
				}
			}
			return this.repo.save(fighting);
		}
	}
}
