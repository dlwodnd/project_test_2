package com.green.hoteldog.board.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.hoteldog.common.Const;
import lombok.Data;

@Data
public class GetMyBoardListDto {
    @JsonIgnore
    private int userPk;
    @JsonIgnore
    private int rowCount = Const.BOARD_COUNT_PER_PAGE;
    private int page;
    @JsonIgnore
    private int startIdx;

    public void setPage(int page){
        this.startIdx = (page - 1) * this.rowCount;
    }
}
