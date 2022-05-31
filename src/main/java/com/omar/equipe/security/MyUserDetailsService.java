package com.omar.equipe.security;


  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.security.core.userdetails.UserDetails; import
  org.springframework.security.core.userdetails.UserDetailsService; import
  org.springframework.security.core.userdetails.UsernameNotFoundException;
  import org.springframework.stereotype.Service;
  
  import com.omar.equipe.entities.User; import
  com.omar.equipe.repos.UserRepository;
  
  
  
  @Service public class MyUserDetailsService implements UserDetailsService {
  
  @Autowired UserRepository userRepository;
  
  @Override public UserDetails loadUserByUsername(String username) throws
  UsernameNotFoundException { User user =
  userRepository.findByUsername(username); return new MyUserDetails(user); } }
 