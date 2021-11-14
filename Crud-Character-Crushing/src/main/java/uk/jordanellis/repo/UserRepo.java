package uk.jordanellis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uk.jordanellis.domain.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

}