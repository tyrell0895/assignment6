package com.meritamerica.assignment6.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.assignment6.models.CDOffering;

public interface CDOfferingRepository extends JpaRepository<CDOffering, Long> {
	
	List<CDOffering> findById(long id);

}
