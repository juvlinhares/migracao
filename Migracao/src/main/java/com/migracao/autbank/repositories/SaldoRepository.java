package com.migracao.autbank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.migracao.autbank.entities.Saldo;

@Repository
public interface SaldoRepository extends JpaRepository<Saldo, Integer> {

}
