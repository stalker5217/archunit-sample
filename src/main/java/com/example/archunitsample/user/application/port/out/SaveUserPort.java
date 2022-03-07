package com.example.archunitsample.user.application.port.out;

import com.example.archunitsample.user.domain.User;

public interface SaveUserPort {
	User save(User user);
}
