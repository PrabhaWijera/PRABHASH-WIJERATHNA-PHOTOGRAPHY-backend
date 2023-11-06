package com.example.prabhash.engineofphotographywebsite.config;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurations {


    @Bean
    public ModelMapper modelMapper(){
      return   new ModelMapper();
    }

}
