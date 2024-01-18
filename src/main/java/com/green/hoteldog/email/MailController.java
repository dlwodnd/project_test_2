package com.green.hoteldog.email;

import com.green.hoteldog.common.RedisUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MailController {
    private final MailSendService mailSendService;


    @PostMapping("/api/mailSend")
    public String sendEmail(@RequestBody @Valid EmailRequestDto dto){
        System.out.println(dto.getEmail());
        mailSendService.joinEmail(dto.getEmail());
        return "ok";

    }
    @PostMapping("/api/mailAuthCheck")
    public String checkMail(@RequestBody @Valid EmailCheckDto dto){
        Boolean checked = mailSendService.CheckAuthNum(dto.getEmail(), dto.getAuthNum());
        if(checked){
            return "ok";
        }
        else {
            return "fail";
        }
    }


}
