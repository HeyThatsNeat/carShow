package com.binaryHunter.carShow.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Service
public class JwtService {
  static final long EXPIRATIONTIME = 864000;
  static final String PREFIX = "Bearer";
  static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); //only used for developement. for production you wont use this
  public String getToken(String username) {
    String token = Jwts.builder()
            .setSubject(username) //give it a username
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))// give experation time
            .signWith(key) //sign it saying its good to go
            .compact();
    return token;
  }
  public String getAuthUser(HttpServletRequest request) { //When the user log in, you give them a token.
    // Each time you want to add something, i will check your token.
    // The token has everything about you.
    String token = request.getHeader(HttpHeaders.AUTHORIZATION);//now we get the toke from the user
    if (token != null) {
      String user = Jwts.parser()
              .verifyWith((SecretKey) key)
              .build()
              .parseSignedClaims(token.replace(PREFIX, ""))
              .getPayload()
              .getSubject();
      if (user != null) return user;
      //Tokens have 3 parts, Header, Body, and Sign
    }
    return null;
  }
}
