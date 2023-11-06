package com.example.prabhash.engineofphotographywebsite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDto implements Serializable ,SuperDto{

    private String id;
    private String email;
    private String name;
    private String subject;
    private String textMessage;
}
