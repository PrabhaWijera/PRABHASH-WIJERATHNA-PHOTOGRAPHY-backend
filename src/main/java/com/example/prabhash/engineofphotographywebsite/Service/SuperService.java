package com.example.prabhash.engineofphotographywebsite.Service;

import com.example.prabhash.engineofphotographywebsite.dto.SuperDto;
import com.example.prabhash.engineofphotographywebsite.dto.UserDto;
import com.example.prabhash.engineofphotographywebsite.res.Response;
import org.springframework.http.ResponseEntity;

public interface SuperService <T extends SuperDto,ID> {
    ResponseEntity<Response> search(String id);

    ResponseEntity <Response>save(T t);

    ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data);
}
