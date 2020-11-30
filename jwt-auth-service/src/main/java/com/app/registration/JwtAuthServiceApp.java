package com.app.registration;

import java.util.ArrayList;
import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.registration.model.Campain;
import com.app.registration.model.Role;
import com.app.registration.model.User;
import com.app.registration.service.CampainService;
import com.app.registration.service.UserService;

@SpringBootApplication
public class JwtAuthServiceApp implements CommandLineRunner {

  @Autowired
  UserService userService;
  @Autowired
  CampainService campainService;
  public static void main(String[] args) {
    SpringApplication.run(JwtAuthServiceApp.class, args);
  }

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Override
  public void run(String... params) throws Exception {
    User admin = new User();
    admin.setUsername("admin");
    admin.setPassword("admin");
    admin.setEmail("admin@email.com");
    admin.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));
    userService.signup(admin);

    User client = new User();
    client.setUsername("client");
    client.setPassword("client");
    client.setEmail("client@email.com");
    client.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_CLIENT)));
    userService.signup(client);
    
    Campain campaign=new Campain();
    campaign.setCampaignName("UA Sports Singapore");
    campaign.setDuration("13 Apr - 28 Apr 2020");
    campaign.setStatus("Published");
    campainService.addCampain(campaign);
    campaign.setCampaignName("SOAP");
    campaign.setDuration("18 Feb - 23 Feb 2020");
    campaign.setStatus("Archieved");
    campainService.addCampain(campaign);
    
    
}
  
}
