package com.example.prabhash.engineofphotographywebsite.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Document
public class UserEntity {

    @MongoId
    @GeneratedValue(strategy = GenerationType.UUID)

    private String id;
    private String email;
    private String name;
    private String subject;
    private String textMessage;




}
