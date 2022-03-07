package com.example.archunitsample.user.adapter.in.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.archunitsample.user.adapter.in.rest.dto.CreateUserDto;
import com.example.archunitsample.user.adapter.out.persistence.entity.UserEntity;
import com.example.archunitsample.user.application.port.in.CreateUserUseCase;
import com.example.archunitsample.user.domain.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
	private final CreateUserUseCase createUserUseCase;

	@PostMapping
	public ResponseEntity<Void> createUser(@RequestBody CreateUserDto.Request userDtoRequest) {
		User user = new User();
		user.setName(userDtoRequest.getName());
		createUserUseCase.createUser(user);

		return ResponseEntity.ok().build();
	}
}
