package com.green.hoteldog.review.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ReviewPatchDto {
    @JsonIgnore
    private int userPk;
    @Min(value = 1,message = "resPk 값은 1 이상이어야 합니다.")
    private int resPk;
    @NotEmpty(message = "comment는 필수 입력값 입니다.")
    private String comment;
}
