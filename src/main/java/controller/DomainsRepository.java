package controller;

import model.Domains;
import org.springframework.data.jpa.repository.JpaRepository;

interface DomainsRepository extends JpaRepository<Domains, Long> {

}