package com.meritamerica.assignment6.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.assignment6.models.SavingsAccount;

public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long > {

	public List<SavingsAccount> findByAccountholder(long id);
}
