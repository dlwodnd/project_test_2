package com.green.hoteldog.board;

import com.green.hoteldog.common.ResVo;
import com.green.hoteldog.board.models.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/board")
public class BoardController {
    private final BoardService service;

    
    //게시글 리스트
    @GetMapping
    public List<GetSimpleBoardVo> getBoardList(GetBoardListDto dto){
        return service.getBoardList(dto);
    }
    //게시글 세부내용
    @GetMapping("/view")
    public GetBoardInfoVo getBoardDetail (GetBoardCommentsDto dto) {
        return service.getBoardInfo(dto);
    }
    //게시글 등록
    @PostMapping
    public ResVo postBoard(@RequestPart List<MultipartFile> pics, @RequestBody PostBoardDto dto){
        dto.setPisc(pics);
        return service.postBoard(dto);
    }
    //게시글 수정
    @PutMapping
    public ResVo putBoard(@RequestPart List<MultipartFile> pics, @RequestBody PutBoardDto dto){
        dto.setPisc(pics);
        return service.putBoard(dto);
    }
    //게시글 좋아요
    @GetMapping("/fav")
    public ResVo patchBoard(BoardFavDto dto){
        return service.putBoardFav(dto);
    }
    //게시글 삭제
    @DeleteMapping
    public ResVo deleteBoard(@RequestBody DeleteBoardDto dto){
        return service.deleteBoard(dto);
    }
    //댓글 작성
    @PostMapping("/comment")
    public ResVo postComment(@RequestBody PostCommentDto dto){
        return service.postComment(dto);
    }
    //댓글 삭제
    @DeleteMapping("/comment")
    public ResVo deleteComment(@RequestBody DeleteCommentDto dto){
        return service.deleteComment(dto);
    }
}