package com.api.CanteenConnect.Dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Userdto {

    private Long id;

    @NotBlank(message = "First name is required")
    @Size(max = 20, message = "First name can have at most 20 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 20, message = "Last name can have at most 20 characters")
    private String lastName;

    @Email(message = "Email should be valid")
    @Size(max = 50, message = "Email can have at most 50 characters")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password should be at least 8 characters")
    private String password;

    @Size(max = 50, message = "Security question can have at most 20 characters")
    private String question;

    @Size(max = 20, message = "Security answer can have at most 20 characters")
    private String answer;
   
   
}
