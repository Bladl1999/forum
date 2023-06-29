package com.forum.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO {

    private Long id;

    private String name;

    private String surname;

    private String role;

    private String email;
    
    private String password;

}
