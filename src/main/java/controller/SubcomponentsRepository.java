package controller;

import model.Subcomponents;
import org.springframework.data.jpa.repository.JpaRepository;

interface SubcomponentsRepository extends JpaRepository<Subcomponents, Long> {

}