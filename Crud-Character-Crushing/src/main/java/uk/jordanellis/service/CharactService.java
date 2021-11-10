package uk.jordanellis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import uk.jordanellis.domain.Charact;
import uk.jordanellis.exceptions.CharacterNotFoundException;
import uk.jordanellis.repo.CharactRepo;

@Service
public class CharactService {

	private CharactRepo repo;

	/**
	 * @param repo
	 */
	public CharactService(CharactRepo repo) {
		super();
		this.repo = repo;
	}

	public Charact getCharact(Integer id) {
		return this.repo.findById(id)
				.orElseThrow(() -> new CharacterNotFoundException("A Character could not be found with ID :" + id));
	}

	public List<Charact> getCharacts() {
		return this.repo.findAll();
	}

	public Charact createCharact(Charact newCharact) {
		return this.repo.save(newCharact);
	}

	public Charact updateCharact(Integer id, Charact updatedCharac) {
		Charact curChar = this.getCharact(id);
		curChar.setCon(updatedCharac.getCon());
		curChar.setDex(updatedCharac.getDex());
		curChar.setHealth(updatedCharac.getHealth());
		curChar.setIntel(updatedCharac.getIntel());
		curChar.setStr(updatedCharac.getStr());
		return this.repo.save(curChar);
	}

	public boolean deleteCharact(Integer id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}
