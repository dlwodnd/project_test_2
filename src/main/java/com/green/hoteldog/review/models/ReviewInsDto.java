package com.green.hoteldog.review.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ReviewInsDto {
    @JsonIgnore
    private int reviewPk;
    @JsonIgnore
    private int userPk;
    @Min(value = 1,message = "resPk 값은 1 이상이어야 합니다.")
    private int resPk;
    @NotBlank(message = "comment 는 필수 입력값 입니다.")
    private String comment;
    @Min(value = 1, message = "score 값은 최소 1입니다.")
    @Max(value = 10, message = "score 값은 최대 10입니다.")
    @NotEmpty
    private int score;
    @JsonIgnore
    private List<MultipartFile> pics;
}
