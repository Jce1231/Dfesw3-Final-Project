package uk.jordanellis.exceptions;

import javax.persistence.EntityNotFoundException;

public class LeaderboardNotFoundException extends EntityNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7988297899693800710L;

	/**
	 * 
	 */
	public LeaderboardNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public LeaderboardNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
