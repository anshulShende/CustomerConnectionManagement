package com.tcs.caseStudy.controller;

import com.tcs.caseStudy.domain.EntityRole;
import com.tcs.caseStudy.dto.client.EntityClientDTO;
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
              @RequestParam("role") EntityRole role, @RequestParam("password") String password) {
        try {
            EntityDTO entity = entityService.authenticateEntity(email, password, role);
            return ResponseEntity.status(HttpStatus.OK).body(entity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e);
        }
    }

    @CrossOrigin
    @GetMapping(path = "/getAllEntities")
    @ApiOperation(value = "fetches All Entities")
    public ResponseEntity getAllEntities() {
        try {
            List<EntityDTO> entity = entityService.getAllEntities();
            return ResponseEntity.status(HttpStatus.OK).body(entity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

    @CrossOrigin
    @GetMapping(path = "/fetchEntity")
    @ApiOperation(value = "fetches All Entities")
    public ResponseEntity fetchEntity(@RequestParam("id") Integer id) {
        try {
            EntityDTO entity = entityService.fetchEntity(id);
            return ResponseEntity.status(HttpStatus.OK).body(entity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

    @CrossOrigin
    @PostMapping(path = "/registerEntity")
    @ApiOperation(value = "register Entities")
    public ResponseEntity registerEntity(@RequestBody EntityClientDTO entity) {
        try {
            entityService.registerEntity(entity);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

    @CrossOrigin
    @PostMapping(path = "/deleteEntity")
    @ApiOperation(value = "register Entities")
    public ResponseEntity deleteEntity(@RequestParam("id") Integer id,
                   @RequestHeader("role") EntityRole role) {
        try {
            entityService.deleteEntity(id, role);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

}
