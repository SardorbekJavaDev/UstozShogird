package com.company.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequestDTO {
    @NotBlank
    @Size(max = 15,min = 3,message = "Name not valid !")
    private String name;
    @NotBlank
    @Size(max = 15,min = 3,message = "Surname not valid !")
    private String surname;
    @NotBlank
    @Size(max = 13, min = 13,message = "Phone not valid !")
    private String phone;
    private String attachId;
}
