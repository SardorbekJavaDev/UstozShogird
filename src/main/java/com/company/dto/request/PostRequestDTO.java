package com.company.dto.request;

import com.company.dto.LikeDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostRequestDTO {

    private String attachId;
    @NotBlank
    @Size(max = 15,min = 3,message = "Payment not valid !")
    private String payment;
    @NotBlank
    @Size(max = 30,min = 3,message = "Profession not valid !")
    private String profession;
    @NotBlank
    @Size(max = 15,min = 4,message = "Time to apply not valid !")
    private String timeToApply;
    @NotBlank
    @Size(max = 300,min = 50,message = "Purpose not valid !")
    private String purpose;
    @NotBlank
    private List<String> tagList;

}
