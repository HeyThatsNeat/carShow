package com.binaryHunter.carShow.web;

import com.binaryHunter.carShow.pojo.AccountCredentials;
import com.binaryHunter.carShow.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
  @Autowired
  private JwtService jwtService;
  @Autowired
  private AuthenticationManager authenticationManager;
  @PostMapping("/login")
  public ResponseEntity<?> getToken(@RequestBody AccountCredentials credentials) {
    UsernamePasswordAuthenticationToken cred = new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword()); //get the username and password
    Authentication auth = authenticationManager.authenticate(cred); //give to authenticate it
    String jwts = jwtService.getToken(auth.getName()); //get a token

    return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, "Bearer" + jwts)
            .header(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "AUTHORIZATION")
            .build();//send the token back to the header of the response and to the user
  }
}
