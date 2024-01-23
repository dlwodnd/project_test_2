package com.green.hoteldog.board.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.models.security.SecurityScheme;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.util.List;

@Data
public class DeleteBoardDto {
    @JsonIgnore
    private int userPk;
    private List<Integer> boardPkList;
}
