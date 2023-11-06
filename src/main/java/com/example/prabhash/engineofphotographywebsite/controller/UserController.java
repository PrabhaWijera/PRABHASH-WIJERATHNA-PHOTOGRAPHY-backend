package com.example.prabhash.engineofphotographywebsite.controller;


import com.example.prabhash.engineofphotographywebsite.Service.custom.UserService;
import com.example.prabhash.engineofphotographywebsite.Service.impl.EmailService;
import com.example.prabhash.engineofphotographywebsite.dto.UserDto;
import com.example.prabhash.engineofphotographywebsite.res.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/c1/User")
public class UserController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;

    @PostMapping(path = "saveUsers",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> sendEmailandsaveDetails(@RequestBody UserDto userDto){
        System.out.println("saving users in controller");

        System.out.println("saving users in controller"+userDto.toString());
        userService.save(userDto);
        System.out.println("🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖");
        System.out.println(userDto.toString());
        return emailService.sendEmailandSave(userDto);
    }

}
