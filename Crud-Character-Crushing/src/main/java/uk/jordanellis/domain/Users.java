package uk.jordanellis.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userid;
	private String name;

	@OneToMany(mappedBy = "users")
	@JsonManagedReference
	private List<Charact> characters = new ArrayList<>();

	@JsonIgnore
	public List<Charact> getCharacters() {
		return this.characters;
	}

	/**
	 * @param name
	 */
	public Users() {
		super();
	}

	public Users(String name) {
		super();
		this.name = name;
	}

	public Users(int id, String name) {
		super();
		this.name = name;
		this.userid = id;
	}

	public String getName() {
		return this.name;
	}

}
