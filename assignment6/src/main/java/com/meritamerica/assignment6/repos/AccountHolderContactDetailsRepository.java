package com.meritamerica.assignment6.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.assignment6.models.AccountHolderContactDetails;

public interface AccountHolderContactDetailsRepository extends JpaRepository<AccountHolderContactDetails, Long> {

	AccountHolderContactDetails findById(long id);
}
