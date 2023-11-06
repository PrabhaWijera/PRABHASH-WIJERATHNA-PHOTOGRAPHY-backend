package com.example.prabhash.engineofphotographywebsite.Service.impl;

import com.example.prabhash.engineofphotographywebsite.dto.UserDto;
import com.example.prabhash.engineofphotographywebsite.repo.EmailRepo;
import com.example.prabhash.engineofphotographywebsite.res.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private EmailRepo emailRepo;

    @Autowired
    private Response response;

    public ResponseEntity<Response> sendEmailandSave(UserDto userDto) {
        String body = " Dear " + userDto.getName() + ",\n\n" +
                "Thank you for Booking With Us !! 🤦📷 \n\n" +
                "Client Details 🔖:\n"+
                "UserEmail: "+ userDto.getEmail() + "\n"+
                "Username: "+ userDto.getName() + "\n"+
                "Subject: "+ userDto.getSubject() + "\n"+
                "Message: "+ userDto.getTextMessage() + "\n"+

                "Regards, \n"+
                "Prabhash Wijerathna - Prabhash Wijerathna PhotoGraphy.";



        try{
            SimpleMailMessage message =new SimpleMailMessage();
            message.setFrom("prabhash04wije@gmail.com");
            message.setSubject("Prabhash Wijerathna PhotoGraphy !!!");
            message.setTo(userDto.getEmail());
            message.setText(body);
            javaMailSender.send(message);



        }catch (MailException e){
            throw new RuntimeException("An error Occurred while Sending the email"+e.getLocalizedMessage());
        }
        response.setStatusCode(200);
        response.setMessage("Email sent Successfully");
        response.setData(null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
