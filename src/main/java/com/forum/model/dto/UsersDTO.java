package com.forum.model.dto;

import com.forum.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO {

    private UUID id;

    private String name;

    private String surname;

    private List<Role> role;

    private String email;
    
    private String password;

}
