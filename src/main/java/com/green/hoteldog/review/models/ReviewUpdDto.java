  package com.green.hoteldog.review.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ReviewUpdDto {
    @JsonIgnore
    private int userPk;
    @JsonIgnore
    private List<MultipartFile> pics;
    @Min(value = 1,message = "reviewPk 값은 1 이상이어야 합니다.")
    private int reviewPk;
    @Min(value = 1,message = "resPk 값은 1 이상이어야 합니다.")
    private int resPk;
    @NotBlank(message = "comment 는 필수 입력값 입니다.")
    private String comment;
    @Min(value = 1, message = "score 값은 최소 1입니다.")
    @Max(value = 10, message = "score 값은 최대 10입니다.")
    private int score;
}
