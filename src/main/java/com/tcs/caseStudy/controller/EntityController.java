package com.tcs.caseStudy.controller;

import com.tcs.caseStudy.dto.database.EntityDTO;
import com.tcs.caseStudy.service.EntityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "Exposes APIs for Customer Connection Management portal")
@RestController
@RequestMapping(path = "/entity")
public class EntityController {

    @Autowired
    private EntityService entityService;

    @CrossOrigin
    @GetMapping(path = "/authenticateEntity")
    @ApiOperation(value = "authenticate Entity and Logs it in")
    public ResponseEntity authenticateEntity(@RequestParam("email") String email,
              @RequestParam("role") String role, @RequestParam("password") String password) {
        try {
            EntityDTO entity = entityService.authenticateEntity(email, password, role);
            return ResponseEntity.status(HttpStatus.OK).body(entity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e);
        }

    }
}
