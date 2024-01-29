package com.green.hoteldog.board.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.hoteldog.common.Const;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class GetBoardInfoDto {
    @Min(value = 1,message = "boardPk 값은 1 이상이어야 합니다.")
    private int boardPk;
    private int page;
    private int rowCount = Const.COMMENT_COUNT_PER_PAGE;
    @JsonIgnore
    private int startIdx;

    public void setStartIdx(int startIdx){
        this.startIdx = (this.page - 1) * this.rowCount;
    }
}
