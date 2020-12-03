package com.app.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.registration.exception.CustomException;
import com.app.registration.model.Campain;
import com.app.registration.repository.CampainRepository;

@Service
public class CampainService {

  @Autowired
  private CampainRepository campainRepository;

  public Campain addCampain(Campain campain) {
	    if (!campainRepository.existsByCampaignName(campain.getCampaignName())) {
	    	System.out.println("Success");
	    	campainRepository.save(campain);
	     	return campainRepository.findByCampaignName(campain.getCampaignName());
	    
	    } else {
	      throw new CustomException("Campain Name is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
	    }
	  }
  

  public List<Campain> listCampain() {
	  return campainRepository.findAll();
  }
  
}
