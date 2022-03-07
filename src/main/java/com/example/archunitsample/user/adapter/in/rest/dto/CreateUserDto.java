package com.example.archunitsample.user.adapter.in.rest.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserDto {
	@Getter
	@Setter
	public static class Request {
		private String name;
	}
}
