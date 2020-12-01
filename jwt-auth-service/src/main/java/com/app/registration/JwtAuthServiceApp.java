package com.app.registration;

import java.util.ArrayList;
import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.app.registration.model.Campain;
import com.app.registration.model.Role;
import com.app.registration.model.User;
import com.app.registration.repository.CampainRepository;
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
    campaign.setCampaignName("SOAP");
    campaign.setDuration("18 Feb - 23 Feb 2020");
    campaign.setStatus("Archieved");
    campainService.addCampain(campaign);
    
    
}
  
 
  @Bean
  public CommandLineRunner init(CampainRepository repository) {
      return args -> {
    	  campainService.addCampain(new Campain("UA Sports Singapore","13 Apr - 18 Apr 2020","Published"));
          repository.save(new Campain("Billboards","19 Apr - 20 Apr 2020","Published"));
          repository.save(new Campain("Focus Media1", "18 Aug - 20 Aug 2020","Processing"));
          repository.save(new Campain("Orchard", "05 Jun - 15 Jul 2020","Archieved"));
          repository.save(new Campain("MW events", "23 Oct - 28 Oct 2020","Published"));
          repository.save(new Campain("AQ Sports", "13 Apr - 28 Apr 2020","Archieved"));
          repository.save(new Campain("Malaysia Billboards", "31 Apr - 06 May 2020","Processing"));
          repository.save(new Campain("Students Campaign", "01 Nov - 20 Nov 2020","Ongoing"));
          repository.save(new Campain("Employee Campaign", "01 Sep - 20 Sep 2020","Published"));
          repository.save(new Campain("Rendezvous", "19 Jul - 29 Jul 2020","Processing"));
          repository.save(new Campain("DBS 3 Billboards", "31 Jun - 15 Jul 2020","Ongoing"));
          repository.save(new Campain("Test Campaign", "18 Mar - 28 Mar 2020","Archieved"));
          repository.save(new Campain("Billboards1", "19 Feb - 28 Feb 2020","Published"));
    	  repository.save(new Campain("Focus Media2", "18 May - 20 Jun 2020","Ongoing"));
           repository.save(new Campain("Focus Media3", "08 Aug - 28 Aug 2020","Processing"));
           repository.save(new Campain("Focus Media4", "17 Sep - 28 Sep 2020","Published"));
           repository.save(new Campain("Focus Media5", "28 Jun - 29 Jun 2020","Ongoing"));
           repository.save(new Campain("Focus Media6", "19 Jul - 28 Jul 2020","Processing"));
           repository.save(new Campain("Focus Media7", "13 Aug - 28 Aug 2020","Ongoing"));
           repository.save(new Campain("Focus Media8", "12 Feb - 18 Feb 2020","Processing"));
           repository.save(new Campain("Billboard", "05 Mar - 08 Mar 2020","Processing"));
           repository.save(new Campain("MW events1", "08 Apr - 18 Aug 2020","Processing"));
           repository.save(new Campain("Students Campaign3", "12 May - 18 Aug 2020","Ongoing"));
           repository.save(new Campain("Employee Campaign1", "17 Jun - 28 Jun 2020","Processing"));
           repository.save(new Campain("Billboards2", "22 Sep - 28 Sep 2020","Ongoing"));
           repository.save(new Campain("Students Campaign2", "26 Nov - 28 Nov 2020","Processing")); 
           repository.save(new Campain("Orchard1", "11 Jul - 28 Jul 2020","Processing"));
           repository.save(new Campain("Rendezvous1", "13 Aug - 23 Aug 2020","Processing"));
      };
  }
  
}
