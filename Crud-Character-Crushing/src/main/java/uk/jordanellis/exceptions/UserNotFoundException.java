package uk.jordanellis.exceptions;

import javax.persistence.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7988297899693800710L;

	/**
	 * 
	 */
	public UserNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
