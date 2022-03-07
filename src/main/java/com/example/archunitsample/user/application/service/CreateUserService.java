package com.example.archunitsample.user.application.service;

import org.springframework.stereotype.Service;

import com.example.archunitsample.user.application.port.in.CreateUserUseCase;
import com.example.archunitsample.user.application.port.out.SaveUserPort;
import com.example.archunitsample.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {
	private final SaveUserPort saveUserPort;

	@Override
	public User createUser(User user) {
		return saveUserPort.save(user);
	}
}
