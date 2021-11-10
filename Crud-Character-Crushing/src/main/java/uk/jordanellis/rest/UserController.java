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
	public Users getUser(@PathVariable Integer id) {
		return this.service.getUser(id);
	}

	@GetMapping("/getAll")
	public List<Users> getUsers() {
		return this.service.getUsers();
	}

	@GetMapping("/test")
	public ResponseEntity<Users> test() {
		Users testing = new Users("Jordan");
		Users responseBody = this.service.createUsers(testing);
		return new ResponseEntity<Users>(responseBody, HttpStatus.CONTINUE);
	}

	@PostMapping("/create")
	public ResponseEntity<Users> createUser(@RequestBody Users newUser) {
		Users responseBody = this.service.createUsers(newUser);
		return new ResponseEntity<Users>(responseBody, HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Users> updateUser(@PathVariable Integer id, @RequestBody Users updatedUser) {
		Users responseBody = this.service.updateUsers(id, updatedUser);
		return new ResponseEntity<Users>(responseBody, HttpStatus.ACCEPTED);
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
