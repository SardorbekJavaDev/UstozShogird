package com.company.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseRequestDTO {

    private String attachId;
    @NotBlank
    @Size(max = 30,min = 3,message = "Office not valid !")
    private String officeName;
    @NotBlank
    @Size(max = 30,min = 3,message = "Payment not valid !")
    private String location;
    @NotBlank
    @Size(max = 15,min = 4,message = "Time to apply not valid !")
    private String timeToApply;
    @NotBlank
    @Size(max = 30,min = 3,message = "Destination not valid !")
    private String destination;
    @NotBlank
    @Size(max = 100,min = 20,message = "Description not valid !")
    private String description;
    @NotBlank
    @Size(max = 15,min = 3,message = "Definition not valid !")
    private String definition;
    @NotBlank
    @Size(max = 15,min = 3,message = "Payment not valid !")
    private String payment;
    @NotBlank
    @Size(max = 15,min = 3,message = "Purpose not valid !")
    private String purpose;
    @NotBlank
    private List<String> tagList;

}
