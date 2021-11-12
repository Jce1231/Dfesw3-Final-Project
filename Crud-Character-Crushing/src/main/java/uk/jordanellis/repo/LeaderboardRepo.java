package uk.jordanellis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uk.jordanellis.domain.Leaderboard;

@Repository
public interface LeaderboardRepo extends JpaRepository<Leaderboard, Integer> {

}