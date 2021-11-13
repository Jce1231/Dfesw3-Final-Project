package uk.jordanellis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import uk.jordanellis.domain.Charact;
import uk.jordanellis.domain.Users;
import uk.jordanellis.dto.CharactDTO;
import uk.jordanellis.exceptions.CharacterNotFoundException;
import uk.jordanellis.repo.CharactRepo;

@Service
public class CharactService {

	private CharactRepo repo;
	private ModelMapper mapper;

	/**
	 * @param repo
	 */
	public CharactService(CharactRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	public CharactDTO mapToDto(Charact charact) {
		return this.mapper.map(charact, CharactDTO.class);
	}

	public CharactDTO getCharact(Integer id) {
		return this.mapToDto(this.repo.findById(id)
				.orElseThrow(() -> new CharacterNotFoundException("A Character could not be found with ID :" + id)));
	}

	public Optional<Charact> getChar(Integer id) {
		return this.repo.findById(id);
	}

	public List<Charact> getChars() {
		return this.repo.findAll();
	}

	public List<CharactDTO> getCharacts() {
		return this.repo.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
	}

	public CharactDTO createCharact(Charact newCharact) {
		return this.mapToDto(this.repo.save(newCharact));
	}

	public CharactDTO updateCharact(Integer id, Charact updatedCharac) {
		Optional<Charact> optChar = this.repo.findById(id);
		Charact curChar = optChar.get();
		curChar.setCon(updatedCharac.getCon());
		curChar.setDex(updatedCharac.getDex());
		curChar.setIntel(updatedCharac.getIntel());
		curChar.setStr(updatedCharac.getStr());
		return this.mapToDto(this.repo.save(curChar));
	}

	public boolean deleteCharact(Integer id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

//This was used to generate test fighters for the database, following the stat guideline
	public List<CharactDTO> generateCharacters(int amount) {
		List<CharactDTO> charList = new ArrayList<>();
		Users systemGen = new Users(1, "System Generated");
		for (int i = 0; i < amount; i++) {
			Random rand = new Random();
			Charact c = new Charact();
			do {
				int rndStr = rand.nextInt(13);
				int rndCon = rand.nextInt(13);
				int rndIntel = rand.nextInt(13);
				int rndDex = rand.nextInt(13);
				c = new Charact(rndIntel, rndStr, rndDex, rndCon, systemGen);
			} while (!c.checkStats());

			this.createCharact(c);
			charList.add(this.mapToDto(c));
			System.out.println("Done :" + i);
		}
		return charList;
	}
}
