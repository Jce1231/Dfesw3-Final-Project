package uk.jordanellis.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Charact implements Stats {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	int intel;
	int str;
	int dex;
	int con;
	int health;
	int maxHealth;
	int speed;

	/**
	 * @param intel
	 * @param str
	 * @param dex
	 * @param con
	 */
	public Charact(int intel, int str, int dex, int con) {
		super();
		this.intel = intel;
		this.str = str;
		this.dex = dex;
		this.con = con;
		this.speed = calcSpeed(this.dex);
	}

	public void attack() {

	}

	public void defend() {

	}

	private int calcSpeed(int a) {
		return (int) (this.dex * 1.5f);
	}

	public boolean checkStats() {
		if (this.str + this.intel + this.con + this.dex != 25) {
			return false;
		} else {
			return true;
		}
	}
}
