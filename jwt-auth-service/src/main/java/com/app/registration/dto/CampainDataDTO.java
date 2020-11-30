package com.app.registration.dto;

public class CampainDataDTO {
  
  private String campaignName;
  private String duration;
  private String status;
  private String campainImage;
  
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
public String getCampainImage() {
	return campainImage;
}
public void setCampainImage(String campainImage) {
	this.campainImage = campainImage;
}
public String getCampaignName() {

	return campaignName;
}

}
