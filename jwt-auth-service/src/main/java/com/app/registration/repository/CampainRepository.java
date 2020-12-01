package com.app.registration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.registration.model.Campain;

public interface CampainRepository extends JpaRepository<Campain, Integer> {

	  boolean existsByCampaignName(String campaignName);

	  Campain findByCampaignName(String campaignName);
	  
	  List<Campain> findAll() ;
	  
	  Campain save(Campain campain);
}
