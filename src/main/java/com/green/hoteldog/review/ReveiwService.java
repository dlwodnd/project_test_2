package com.green.hoteldog.review;

import com.green.hoteldog.common.MyFileUtils;
import com.green.hoteldog.common.ResVo;
import com.green.hoteldog.review.models.*;
import com.green.hoteldog.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReveiwService {
    private final ReviewMapper mapper;
    private final AuthenticationFacade authentication;
    private final MyFileUtils fileUtils;

    //리뷰 등록
    public ResVo insReview(ReviewInsDto dto) {
        ReviewInsPicsDto picsDto = new ReviewInsPicsDto();
        picsDto.setReviewPk(dto.getReviewPk());
        picsDto.setPics(dto.getPics());
        int result = mapper.insReview(dto);
        mapper.insReviewPics(picsDto);
        return new ResVo(result);
    }

    //리뷰 전체 수정
    public ResVo putReview(ReviewUpdDto dto) {
        try {
            mapper.updReview(dto);
            mapper.delReviewPics(dto);
            ReviewInsPicsDto picsDto = new ReviewInsPicsDto();
            picsDto.setReviewPk(dto.getReviewPk());
            picsDto.setPics(dto.getPics());
            mapper.insReviewPics(picsDto);
            return new ResVo(1);
        } catch (Exception e) {
            return null;
        }
    }

    //리뷰 코멘트 수정
    public ResVo patchReviewComment(ReviewPatchDto dto) {
        try {
            mapper.updReviewComment(dto);
            return new ResVo(1);
        } catch (Exception e) {
            return null;
        }
    }

    //리뷰 좋아요 토글
    public ResVo patchReviewFav(int reviewPk) {
        ReviewFavDto dto = new ReviewFavDto();
        dto.setReviewPk(reviewPk);
        dto.setUserPk(authentication.getLoginUserPk());

        if (mapper.delReviewFav(dto) == 0) {
            int result = mapper.insReviewFav(dto);
            return new ResVo(result);
        }
        return new ResVo(2);
    }

    //호텔 리뷰 리스트
    public List<HotelReviewSelVo> hotelReviewList(HotelReviewSelDto dto) {
        List<HotelReviewSelVo> reviewList = mapper.selHotelReviewList(dto);

        if (reviewList.size() > 0) {
            List<Integer> reviewPkList = new ArrayList<>();
            Map<Integer, HotelReviewSelVo> reviewSelVoMap = new HashMap<>();
            for (HotelReviewSelVo vo : reviewList) {
                reviewPkList.add(vo.getReviewPk());
                reviewSelVoMap.put(vo.getReviewPk(), vo);
            }
            List<ReviewPicVo> picVoList = mapper.selReviewPics(reviewPkList);
            for (ReviewPicVo vo : picVoList) {
                HotelReviewSelVo selVo = reviewSelVoMap.get(vo.getReviewPk());
                if (selVo.getPics() == null) {
                    selVo.setPics(new ArrayList<>());
                }
                selVo.getPics().add(vo.getPic());
            }
        }
        return reviewList;
    }
}
