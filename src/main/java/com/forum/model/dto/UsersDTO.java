package com.forum.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO {

//    @JsonProperty("id")
    private Long id;

//    @JsonProperty("name")
    private String name;

//    @JsonProperty("surname")
    private String surname;

//    @JsonProperty("role")
    private String role;

//    @JsonProperty("email")
    private String email;

//    @JsonProperty("password")
    private String password;

}
