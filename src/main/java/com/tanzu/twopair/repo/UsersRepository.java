package com.tanzu.twopair.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanzu.twopair.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}