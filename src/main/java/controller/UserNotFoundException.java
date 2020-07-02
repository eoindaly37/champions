package controller;

public class UserNotFoundException extends RuntimeException {

	UserNotFoundException(Long id) {
		super("Could not find employee " + id);
	}
}