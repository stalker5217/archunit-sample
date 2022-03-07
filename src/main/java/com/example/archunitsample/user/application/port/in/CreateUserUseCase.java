package com.example.archunitsample.user.application.port.in;

import com.example.archunitsample.user.domain.User;

public interface CreateUserUseCase {
	public User createUser(User user);
}
