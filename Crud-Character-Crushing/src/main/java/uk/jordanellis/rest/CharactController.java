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

import uk.jordanellis.domain.Charact;
import uk.jordanellis.service.CharactService;

@RestController
@RequestMapping("/char")
public class CharactController {
	private CharactService service;

	/**
	 * @param service
	 */
	public CharactController(CharactService service) {
		super();
		this.service = service;
	}

	@GetMapping("/get/{id}")
	public Charact getChar(@PathVariable Integer id) {
		return this.service.getCharact(id);
	}

	@GetMapping("/getAll")
	public List<Charact> getChars() {
		return this.service.getCharacts();
	}

	@PostMapping("/create")
	public ResponseEntity<Charact> createChar(@RequestBody Charact newCharact) {
		Charact responseBody = this.service.createCharact(newCharact);
		return new ResponseEntity<Charact>(responseBody, HttpStatus.CREATED);
	}

	@GetMapping("/test")
	public String test() {
		return "Hello";
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Charact> updateChar(@PathVariable Integer id, @RequestBody Charact updatedChar) {
		Charact responseBody = this.service.updateCharact(id, updatedChar);
		return new ResponseEntity<Charact>(responseBody, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteChar(@PathVariable Integer id) {
		Boolean removed = this.service.deleteCharact(id);
		if (removed) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
//This was used to populate my database with test fighters
//	@GetMapping("/generate")
//	public String generateChar() {
//		this.service.generateCharacters();
//		return "Characters Generated";
//
//	}
}
