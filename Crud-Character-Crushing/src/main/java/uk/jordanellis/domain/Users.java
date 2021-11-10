package uk.jordanellis.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;

	/**
	 * @param name
	 */
	public Users(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
