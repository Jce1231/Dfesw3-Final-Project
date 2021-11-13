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
import uk.jordanellis.dto.CharactDTO;
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
	public CharactDTO getChar(@PathVariable Integer id) {
		return this.service.getCharact(id);
	}

	@GetMapping("/getAll")
	public List<CharactDTO> getChars() {
		return this.service.getCharacts();
	}

	@PostMapping("/create")
	public ResponseEntity<CharactDTO> createChar(@RequestBody Charact newCharact) {
		CharactDTO responseBody = this.service.createCharact(newCharact);
		return new ResponseEntity<CharactDTO>(responseBody, HttpStatus.CREATED);
	}

	@GetMapping("/test")
	public String test() {
		return "Hello";
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<CharactDTO> updateChar(@PathVariable Integer id, @RequestBody Charact updatedChar) {
		CharactDTO responseBody = this.service.updateCharact(id, updatedChar);
		return new ResponseEntity<CharactDTO>(responseBody, HttpStatus.ACCEPTED);
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
	@PostMapping("/generate/{amount}")
	public ResponseEntity<List<CharactDTO>> generateChar(@PathVariable int amount) {
		return new ResponseEntity<List<CharactDTO>>(this.service.generateCharacters(amount), HttpStatus.CREATED);

	}
}
