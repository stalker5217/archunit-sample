package com.example.archunitsample.user.adapter.out.persistence;

import org.springframework.stereotype.Service;

import com.example.archunitsample.user.adapter.out.persistence.entity.UserEntity;
import com.example.archunitsample.user.adapter.out.persistence.repository.UserRepository;
import com.example.archunitsample.user.application.port.out.SaveUserPort;
import com.example.archunitsample.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaveUserAdapter implements SaveUserPort {
	private final UserRepository userRepository;

	@Override
	public User save(User user) {
		UserEntity userEntity = new UserEntity();
		userEntity.setName(user.getName());

		UserEntity result = userRepository.save(userEntity);

		User ret = new User();
		ret.setId(result.getId());
		ret.setName(result.getName());

		return ret;
	}
}
