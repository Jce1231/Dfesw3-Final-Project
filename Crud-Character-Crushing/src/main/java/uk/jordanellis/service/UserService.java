package uk.jordanellis.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import uk.jordanellis.domain.Users;
import uk.jordanellis.dto.UsersDTO;
import uk.jordanellis.dto.UsersNoCharactDTO;
import uk.jordanellis.exceptions.UserNotFoundException;
import uk.jordanellis.repo.UserRepo;

@Service
public class UserService {
	private UserRepo repo;
	private ModelMapper mapper;

	/**
	 * @param repo
	 * @param mapper
	 */
	public UserService(UserRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	private UsersDTO mapToDto(Users users) {
		return this.mapper.map(users, UsersDTO.class);
	}

	public UsersDTO getUser(Integer id) {
		return this.mapToDto(this.repo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("A User could not be found with ID :" + id)));
	}

	public List<UsersNoCharactDTO> getUsers() {
		return this.repo.findAll().stream().map(n -> this.mapper.map(n, UsersNoCharactDTO.class))
				.collect(Collectors.toList());
	}

	public List<UsersDTO> getAllUserChar() {
		return this.repo.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
	}

	public UsersDTO createUsers(Users newUser) {
		System.out.println(newUser);
		return this.mapToDto(this.repo.save(newUser));
	}

	public UsersDTO updateUsers(Integer id, Users updatedUser) {

		Optional<Users> optionalUser = this.repo.findById(id);
		Users curUser = optionalUser.get();
		curUser.setName(updatedUser.getName());
		return this.mapToDto(this.repo.save(curUser));
	}

	public boolean deleteUsers(Integer id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}
