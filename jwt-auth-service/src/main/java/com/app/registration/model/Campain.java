package com.app.registration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Campain {

  

@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;


  @Column(unique = true, nullable = false)
  private String campaignName;

  @Column(unique = true, nullable = false)
  private String duration;

  @Column(unique = false, nullable = false)
  private String status;

 // @Column(unique = false, nullable = true)
//  private String campainImage;
  

//public void setCampainImage(String campainImage) {
	//this.campainImage = campainImage;
//}

  public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
