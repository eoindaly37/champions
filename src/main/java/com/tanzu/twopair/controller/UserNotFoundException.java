package com.tanzu.twopair.controller;

public class UserNotFoundException extends RuntimeException {

	UserNotFoundException(Long id) {
		super("Could not find employee " + id);
	}
}