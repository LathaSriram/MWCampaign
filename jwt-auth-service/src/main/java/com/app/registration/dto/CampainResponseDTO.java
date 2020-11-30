package com.app.registration.dto;

public class CampainResponseDTO {
  
  private Integer id;
  private String campaignName;
  private String duration;
  private String status;
  private String campainImage;
  
public String getCampaignImage() {
	return campainImage;
}

public void setCampainImage(String campainImage) {
	this.campainImage = campainImage;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getCampaignName() {
	return campaignName;
}
public void setCampainName(String campaignName) {
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
