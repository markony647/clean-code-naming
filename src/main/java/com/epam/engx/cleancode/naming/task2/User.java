package com.epam.engx.cleancode.naming.task2;

import java.util.Arrays;

public class User {

	protected boolean isAdmin = false;

	private final String birth;

	private final String name;

	private final User[] subordinateArray;

	private int rating;

	public User(String name, String birth, User[] subordinates) {
		this.birth = birth;
		this.name = name;
		this.subordinateArray = subordinates;
	}

	@Override
	public String toString() {
		return "User [dateOfBirth=" + birth + ", name=" + name + ", isAdmin=" + isAdmin + ", subordinates="
				+ Arrays.toString(subordinateArray) + ", rating=" + rating + "]";
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
