package controller;

import model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

interface UsersRepository extends JpaRepository<Users, Long> {

}