package com.example.mobi.config;

import com.example.mobi.model.binding.UserLoginBindingModel;
import com.example.mobi.model.service.UserLoginServiceModel;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration
public class ApplicationConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new Pbkdf2PasswordEncoder();
    }

    @Bean
    public ModelMapper modelMapper(){

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(UserLoginBindingModel.class, UserLoginServiceModel.class)
                .addMapping(UserLoginBindingModel::getPassword, UserLoginServiceModel::setRawPassword);

        return modelMapper;
    }

}
