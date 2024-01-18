package com.binaryHunter.carShow.security;

import com.binaryHunter.carShow.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //will remove the basic Spring security, so we can solely use our own code instead
public class SecurityConfig {
  @Autowired
  private UserServiceImpl userService;
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //Everyone should be able to get Get. but only the admin should be able to Post
    return http
            .cors(Customizer.withDefaults()) //Cross-Origin Resource Sharing (CORS)
            .csrf(c -> c.disable())// Cross Site Request Forgery (CSRF) attack
            .httpBasic(Customizer.withDefaults()) //get the basic username and password
            .authorizeHttpRequests(
                    auth -> auth.requestMatchers(HttpMethod.GET, "/api/v1/car/*").hasAnyRole("USER", "ADMIN")//allow anyone to get from the car path
                            .requestMatchers(HttpMethod.POST, "/api/v1/car/*").hasRole("ADMIN")// allow only Admins to post on car path
                            .anyRequest().authenticated() //anyone else should be authenticated (should log in)
            )
            .build();
  }

  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userService)
            .passwordEncoder(new BCryptPasswordEncoder());
  }
}


//  @Bean
//  public UserDetailsService userDetailsService() {
//    UserDetails admin = User.builder() //this line
//            .username("admin")
//            .password(bCryptPasswordEncoder().encode("adminPass")) //dont use just a string, need to encode password
//            .roles("ADMIN")
//            .build();
//    var user = User.builder() //another way of doing like line 27
//            .username("user")
//            .password(bCryptPasswordEncoder().encode("userPass")) //dont use just a string, need to encode password
//            .roles("USER")
//            .build();
//    return new InMemoryUserDetailsManager(user, admin);
//  }
//
//  @Bean //used to encode a password
//  public BCryptPasswordEncoder bCryptPasswordEncoder(){
//    return new BCryptPasswordEncoder();
//  }
//
//}
