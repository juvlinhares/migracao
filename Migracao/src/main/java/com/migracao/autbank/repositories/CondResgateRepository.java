package com.migracao.autbank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.migracao.autbank.entities.CondResgate;

@Repository
public interface CondResgateRepository extends JpaRepository<CondResgate, Integer>{

}
