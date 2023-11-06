package com.example.prabhash.engineofphotographywebsite.Service.impl;

import com.example.prabhash.engineofphotographywebsite.Service.custom.UserService;
import com.example.prabhash.engineofphotographywebsite.dto.UserDto;
import com.example.prabhash.engineofphotographywebsite.entity.UserEntity;
import com.example.prabhash.engineofphotographywebsite.repo.UserRepo;
import com.example.prabhash.engineofphotographywebsite.res.Response;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UserServices implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Response response;


    @Override
    public ResponseEntity<Response> search(String id) {
        Optional<UserEntity> userEntity=userRepo.findById(id);
        if (userEntity.isPresent()){
            return createAndSendResponse(HttpStatus.OK.value(),"Success service",modelMapper.map(userEntity.get(), UserDto.class));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "User NOT Found Error",null);
    }

    @Override
    public ResponseEntity<Response> save(UserDto userDto) {
        if (search(userDto.getId()).getBody().getData() == null){
            userRepo.save(modelMapper.map(userDto,UserEntity.class));
            return createAndSendResponse(HttpStatus.OK.value(),"Success save",userDto);
        }
        throw new RuntimeException("No saving");
    }




    @Override
    public ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(msg);
        response.setData(data);
        System.out.println("Status code : " + statusCode);
        System.out.println("Sent :"+HttpStatus.valueOf(statusCode));

        return new ResponseEntity<Response>(response, HttpStatusCode.valueOf(statusCode));
    }


}
