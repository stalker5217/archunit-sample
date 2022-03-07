package com.example.archunitsample.user.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.archunitsample.user.adapter.out.persistence.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
