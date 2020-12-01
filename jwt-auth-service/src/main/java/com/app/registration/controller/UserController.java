package com.app.registration.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.dto.CampainDataDTO;
import com.app.registration.dto.TokenResponseDTO;
import com.app.registration.dto.UserDataDTO;
import com.app.registration.dto.UserResponseDTO;
import com.app.registration.model.Campain;
import com.app.registration.model.User;
import com.app.registration.service.CampainService;
import com.app.registration.service.UserService;


@RestController

public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private CampainService campainService;
  
  @Autowired
  private ModelMapper modelMapper;
//  http://ec2-3-135-228-77.us-east-2.compute.amazonaws.com:8081/
  @PostMapping("/login")
  @CrossOrigin(origins="http://localhost:4200")
  public TokenResponseDTO login(@RequestBody UserDataDTO user) {
	String token =  userService.signin(user.getUsername(), user.getPassword());
	TokenResponseDTO tokenDAO = new TokenResponseDTO();
	tokenDAO.setToken(token);
	return tokenDAO  ;
  }

 
  @PostMapping("/signup")
  @CrossOrigin(origins="http://localhost:4200")
  public String signup(@RequestBody UserDataDTO user) {
	  System.out.println("singup method");
    return userService.signup(modelMapper.map(user, User.class));
  }

  
  @GetMapping("/signout")
  public void signout(@RequestHeader(value="Authorization") String authorizationHeader) {
	  String token = authorizationHeader.substring(7);
	  System.out.println("Authorirization Header @"+token);
	  
	  userService.logout(token);
  }
  
  @PostMapping("/addCampain")
  @CrossOrigin(origins="http://localhost:4200")
  public Campain addCampain(@RequestBody CampainDataDTO campain) {
	 
	  System.out.println("details passed:"+campain.getCampaignName());
    return campainService.addCampain((modelMapper.map(campain, Campain.class)));
  }

  @GetMapping("/listCampain")
  @CrossOrigin(origins="http://localhost:4200")
  public List<Campain> listCampain() {
    return campainService.listCampain();
  }
  
  @GetMapping(value = "/me")
  public UserResponseDTO whoami(HttpServletRequest req) {
    return modelMapper.map(userService.whoami(req), UserResponseDTO.class);
  }

  @GetMapping("/refresh")
  public String refresh(HttpServletRequest req) {
    return userService.refresh(req.getRemoteUser());
  }

}
