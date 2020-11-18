package com.tcs.caseStudy.dto.database;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntityDTO {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private String role;
    private String password;
}
