package com.example.prabhash.engineofphotographywebsite.repo;

import com.example.prabhash.engineofphotographywebsite.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepo extends MongoRepository<UserEntity,String> {
}
