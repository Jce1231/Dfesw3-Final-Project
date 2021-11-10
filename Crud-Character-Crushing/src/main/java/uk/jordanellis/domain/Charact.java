package uk.jordanellis.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Charact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int intel;
	private int str;
	private int dex;
	private int con;
	private int health;
	private int speed;

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
		calcSpeed();
	}

	public void setDex(int dex) {
		this.dex = dex;
		calcSpeed();
	}

	public void attack() {

	}

	public void defend() {

	}

	private void calcSpeed() {
		this.speed = (int) (this.dex * 1.5f);
	}

	public boolean checkStats() {
		if (this.str + this.intel + this.con + this.dex != 25) {
			return false;
		} else {
			return true;
		}
	}
}
