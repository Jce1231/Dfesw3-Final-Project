package uk.jordanellis.dto;

import lombok.Data;

@Data
public class LBDto {
	private int lbID;
	private CharactDTO attacker;
	private int wins;
	private int losses;
}
