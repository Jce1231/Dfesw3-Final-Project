package uk.jordanellis.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uk.jordanellis.domain.Users;
import uk.jordanellis.dto.UsersDTO;
import uk.jordanellis.dto.UsersNoCharactDTO;
import uk.jordanellis.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	private UserService service;

	/**
	 * @param service
	 */
	public UserController(UserService service) {
		super();
		this.service = service;
	};

	@GetMapping("/get/{id}")
	public UsersDTO getUser(@PathVariable Integer id) {
		return this.service.getUser(id);
	}

	@GetMapping("/getUsers")
	public List<UsersNoCharactDTO> getUsers() {
		return this.service.getUsers();
	}

	@GetMapping("/getUserChar")
	public List<UsersDTO> getUserChar() {
		return this.service.getAllUserChar();
	}

	@PostMapping("/create")
	public ResponseEntity<UsersDTO> createUser(@RequestBody Users newUser) {
		UsersDTO responseBody = this.service.createUsers(newUser);
		return new ResponseEntity<UsersDTO>(responseBody, HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<UsersDTO> updateUser(@PathVariable Integer id, @RequestBody Users updatedUser) {
		UsersDTO responseBody = this.service.updateUsers(id, updatedUser);
		return new ResponseEntity<UsersDTO>(responseBody, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
		Boolean removed = this.service.deleteUsers(id);
		if (removed) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
