package com.tcs.caseStudy.dto.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntityClientDTO {
    private String name;
    private String email;
    private String phone;
    private String gender;
    private String role;
    private String password;

}
