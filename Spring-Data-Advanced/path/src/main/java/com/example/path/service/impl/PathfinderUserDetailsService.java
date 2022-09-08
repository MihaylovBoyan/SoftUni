package com.example.path.service.impl;

import com.example.path.model.entity.User;
import com.example.path.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PathfinderUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public PathfinderUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User userEntity = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User with email" + email + "was not found"));
        return map(userEntity);
    }

    private UserDetails map(User user){

        Set<GrantedAuthority> grantedAuthorities = user.getRoles()
                .stream()
                .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getRole().name()))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                grantedAuthorities
        );

    }
}
