package uk.jordanellis.dto;

import lombok.Data;

@Data
public class CharactDTO {
	private int charactId;
	private int health;
	private int dmg;
	private UsersNoCharactDTO users;

}
