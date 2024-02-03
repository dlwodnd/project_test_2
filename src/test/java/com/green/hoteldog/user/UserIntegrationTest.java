package com.green.hoteldog.user;

import com.green.hoteldog.BaseIntegrationTest;
import com.green.hoteldog.email.EmailRequestDto;
import com.green.hoteldog.email.MailController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

public class UserIntegrationTest extends BaseIntegrationTest {
    @Autowired
    private MailController mailController;


    @Test
    @Rollback
    public void userSignup(){
        EmailRequestDto dto = new EmailRequestDto();
        dto.setEmail("asdfwq123@gmail.com");

    }
    @Test
    @Rollback
    public void userSignin(){

    }
    @Test
    @Rollback
    public void nicknameCheck(){

    }
    @Test
    @Rollback
    public void userInfo(){

    }
    @Test
    @Rollback
    public void updUserInfo(){

    }

}
