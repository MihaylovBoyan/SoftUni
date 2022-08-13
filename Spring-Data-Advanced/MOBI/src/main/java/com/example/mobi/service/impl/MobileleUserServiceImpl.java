package com.example.mobi.service.impl;

import com.example.mobi.model.entity.UserEntity;
import com.example.mobi.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MobileleUserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public MobileleUserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // The purpose of this method is to map our user representation (UserEntity)
        // to the user representation in the spring security world (UserDetails)
        // The only thing that spring will provide to us is the username
        // The username will come from the HTML login form
        UserEntity userEntity = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " not found"));


        return mapToUserDetails(userEntity);
    }


    private static UserDetails mapToUserDetails(UserEntity user) {

        // GrantedAuthority is the representation of a user role in the spring world.
        // SimpleGrantedAuthority is an implementation of GrantedAuthority which spring provides for our convenience.
        // Our representation of role is userRoleEntity.
        List<GrantedAuthority> authorities = user
                .getRoles()
                .stream()
                .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getRole().name()))
                .collect(Collectors.toList());

        // User is the spring implementation of UserDetails interface.
        return new MobileleUser(user.getUsername(), user.getPassword(), authorities);
    }

}
