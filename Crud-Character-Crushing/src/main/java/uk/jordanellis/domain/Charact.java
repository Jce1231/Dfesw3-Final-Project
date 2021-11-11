package uk.jordanellis.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
@Table(name = "charact")
public class Charact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "charact_id")
	private int charactId;
	private int intel;
	private int str;
	private int dex;
	private int con;
	private int health;
	private int speed;
	private int dmg;
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private Users users;

	/**
	 * @param intel
	 * @param str
	 * @param dex
	 * @param con
	 */
	public Charact(int intel, int str, int dex, int con, Users users) {
		super();
		this.setIntel(intel);
		this.setStr(str);
		this.setDex(dex);
		this.setCon(con);
		this.users = users;
	}

	public Charact(int charactId, int intel, int str, int dex, int con, Users users) {
		super();
		this.charactId = charactId;
		this.setIntel(intel);
		this.setStr(str);
		this.setDex(dex);
		this.setCon(con);
		this.users = users;
	}

	public Charact() {
		super();
	}

	public void calcHp() {
		this.health = (int) ((this.con * 2f) + (this.str * 1.25f)) * 10;
	}

	public void setCon(int con) {
		this.con = con;
		calcHp();
	}

	public void setStr(int str) {
		this.str = str;
		calcHp();
		calcDmg();
	}

	public void setDex(int dex) {
		this.dex = dex;
		calcSpeed();
	}

	public void calcDmg() {
		this.dmg = (int) ((int) ((this.str * 2.5f) + this.dex / 3f) * 1.5f);
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

	/**
	 * @param charactId
	 * @param intel
	 * @param str
	 * @param dex
	 * @param con
	 * @param users
	 */

}
