package uk.jordanellis.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class UsersDTO {
	private int userid;
	private String name;
	private List<CharactNoUserDTO> characters = new ArrayList<>();
}
