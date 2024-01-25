package com.green.hoteldog.user;

import com.green.hoteldog.common.AppProperties;
import com.green.hoteldog.common.CookieUtils;
import com.green.hoteldog.common.ResVo;
import com.green.hoteldog.exceptions.CustomException;
import com.green.hoteldog.exceptions.UserErrorCode;
import com.green.hoteldog.security.AuthenticationFacade;
import com.green.hoteldog.security.JwtTokenProvider;
import com.green.hoteldog.security.Myprincipal;
import com.green.hoteldog.user.models.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;
    private final AppProperties appProperties;
    private final CookieUtils cookie;
    private final AuthenticationFacade facade;
    //유저 회원가입
    public ResVo userSignup (UserSignupDto dto){
        String pw = passwordEncoder.encode(dto.getUpw());
        dto.setUpw(pw);
        dto.setUserEmail(dto.getEmailResponseVo().getEmail());
        dto.setUserTypePk(1);
        try{
            mapper.userSignup(dto);
            mapper.insUserAddress(dto.getAddressEntity());
            return new ResVo(1);
        }catch (Exception e){
            return new ResVo(0);
        }
    }
    //유저 로그인
    public UserSigninVo userSignin(HttpServletResponse response, HttpServletRequest request, UserSigninDto dto){
        UserSigninVo vo = new UserSigninVo();
        UserEntity userEntity = mapper.userEntityByUserEmail(dto.getUserEmail());
        if(userEntity == null){
            throw new CustomException(UserErrorCode.UNKNOWN_EMAIL_ADDRESS);
        }
        if(!passwordEncoder.matches(dto.getUpw(),userEntity.getUpw())){
            throw new CustomException(UserErrorCode.MISS_MATCH_PASSWORD);
        }
        Myprincipal myprincipal = new Myprincipal(userEntity.getUserPk());
        String at = tokenProvider.generateAccessToken(myprincipal);
        String rt = tokenProvider.generateRefreshToken(myprincipal);
        List<Integer> dogSizeList = mapper.selUserDogSize(userEntity.getUserPk());

        int rtCookieMaxAge = (int)appProperties.getJwt().getRefreshTokenExpiry() / 1000;
        cookie.deleteCookie(response,"rt");
        cookie.setCookie(response,"rt",rt,rtCookieMaxAge);

        vo.setDepthName(mapper.selUserDepthName(userEntity.getUserPk()));
        vo.setSizePkList(dogSizeList);
        vo.setUserPk(userEntity.getUserPk());
        vo.setUserTypePk(userEntity.getUserTypePk());
        vo.setAccessToken(at);
        vo.setNickname(userEntity.getNickname());
        return vo;
    }
    public ResVo checkNickname(String nickname){
        List<UserEntity> userEntityList = mapper.selUserEntity();
        for(UserEntity entity : userEntityList){
            if(entity.getNickname().equals(nickname)){
                return new ResVo(0);
            }
        }
        return new ResVo(1);
    }
    public ResVo signout(HttpServletResponse response){
        cookie.deleteCookie(response,"rt");
        return new ResVo(1);
    }
    public UserInfoVo getUserInfo (UserInfoDto dto){
        dto.setUserPk(facade.getLoginUserPk());
        if(dto.getUserPk() == 0){
            //예외처리 로그인 안한 유저
        }
        UserEntity entity = mapper.userEntityByUserPk(dto.getUserPk());
        if(entity == null){
            //예외처리 없는 userPk
        }
        if(!passwordEncoder.matches(dto.getUpw(), entity.getUpw())){
            //예외처리 비밀번호 틀림
        }
        UserInfoVo vo = new UserInfoVo();
        vo.setUserPk(entity.getUserPk());
        vo.setUserEmail(entity.getUserEmail());
        vo.setNickname(entity.getNickname());
        vo.setPhoneNum(entity.getPhoneNum());
        vo.setUserAddress(entity.getUserAddress());
        return vo;
    }
    public ResVo updUserInfo(UserUpdateDto dto){
        dto.setUserPk(facade.getLoginUserPk());
        if(dto.getUserPk() == 0){
            //예외처리 로그인 정보 없음
        }
        try {
            mapper.updateUserInfo(dto);
            return new ResVo(1);
        }catch (Exception e){
            return new ResVo(0);
        }
    }

}
