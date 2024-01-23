package com.green.hoteldog.board.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.util.List;

@Data
public class DeleteCommentDto {
    private int userPk;
    private List<Integer> commentPkList;
}
