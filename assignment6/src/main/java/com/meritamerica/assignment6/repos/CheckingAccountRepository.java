package com.meritamerica.assignment6.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.assignment6.models.CheckingAccount;

public interface CheckingAccountRepository extends JpaRepository<CheckingAccount,Long> {
	
	List<CheckingAccount> findByAccountHolder(Long id);

}
