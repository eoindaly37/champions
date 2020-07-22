package com.tanzu.twopair.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanzu.twopair.model.Domains;

public interface DomainsRepository extends JpaRepository<Domains, Long> {

}