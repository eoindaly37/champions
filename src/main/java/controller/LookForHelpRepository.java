package controller;

import model.LookForHelp;
import org.springframework.data.jpa.repository.JpaRepository;

interface LookForHelpRepository extends JpaRepository<LookForHelp, Long> {

}