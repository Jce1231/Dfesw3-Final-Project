package uk.jordanellis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import uk.jordanellis.domain.Users;
import uk.jordanellis.exceptions.UserNotFoundException;
import uk.jordanellis.repo.UserRepo;

@Service
public class UserService {
	private UserRepo repo;

	/**
	 * @param repo
	 */
	public UserService(UserRepo repo) {
		super();
		this.repo = repo;
	}

	public Users getUser(Integer id) {
		return this.repo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("A User could not be found with ID :" + id));
	}

	public List<Users> getUsers() {
		return this.repo.findAll();
	}

	public Users createUsers(Users newUser) {
		return this.repo.save(newUser);
	}

	public Users updateUsers(Integer id, Users updatedUser) {
		Users curUser = this.getUser(id);
		curUser.setName(curUser.getName());
		return this.repo.save(curUser);
	}

	public boolean deleteUsers(Integer id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}
