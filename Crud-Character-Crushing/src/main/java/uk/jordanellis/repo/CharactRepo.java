package uk.jordanellis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uk.jordanellis.domain.Charact;

@Repository
public interface CharactRepo extends JpaRepository<Charact, Integer> {

}