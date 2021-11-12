package uk.jordanellis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public void initialise() {
		this.service.getCharacts().forEach(n -> this.repo.save(new Leaderboard(n, 0, 0)));
	}

	public void fightLoop() {

		ArrayList<Leaderboard> leaderboard = new ArrayList<>();
		leaderboard = (ArrayList<Leaderboard>) this.repo.findAll();
		for (int i = 0; i <= leaderboard.size() - 1; i++) {
			Leaderboard fighter = leaderboard.get(i);
			for (int j = i; j <= leaderboard.size() - 1; j++) {
				if (i != j) {
					Leaderboard defender = leaderboard.get(j);
					fight(fighter, defender);
					System.out.println("Loop I: " + i + " Loop J: " + j);
					leaderboard.set(j, defender);

				}
			}
			leaderboard.set(i, fighter);
		}
		this.repo.saveAll(leaderboard);
	}

	public void fight(Leaderboard fighter, Leaderboard defender) {
		if (fighter.getAttacker() == defender.getAttacker()) {
		} else {
			while (fighter.getAttacker().getHealth() >= 1 && defender.getAttacker().getHealth() >= 1) {
				if (fighter.getAttacker().getSpeed() >= defender.getAttacker().getSpeed()) {
					fighter.getAttacker().attack(defender.getAttacker());
					if (defender.getAttacker().getHealth() >= 1) {
						defender.getAttacker().attack(fighter.getAttacker());
					} else {
					}
				} else {
					defender.getAttacker().attack(fighter.getAttacker());
					if (fighter.getAttacker().getHealth() >= 1) {
						fighter.getAttacker().attack(defender.getAttacker());
					} else {
					}
				}
			}
			if (defender.getAttacker().getHealth() > fighter.getAttacker().getHealth()) {
				fighter.addLoss();
				defender.addWin();
			} else {
				fighter.addWin();
				defender.addLoss();
			}

			fighter.getAttacker().calcHp();
			defender.getAttacker().calcHp();
		}
	}
}
