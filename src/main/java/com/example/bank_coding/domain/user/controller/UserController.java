package com.example.bank_coding.domain.user.controller;

import com.example.bank_coding.domain.user.UserService;
import com.example.bank_coding.dto.ResponseDto;
import com.example.bank_coding.dto.user.request.JoinRequestDto;
import com.example.bank_coding.dto.user.response.JoinResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    // 만약 @RequestBody 사용하지 않는다면 x-www form url 형식으로 받게 되어 "username=david&fullName=parkdavid" 식으로 받아옴
    // 따라서 json 형식으로 데이터를 받아오고자 한다면 RequestBody 사용해야 한다.
    public ResponseEntity<?> join(@RequestBody @Valid JoinRequestDto joinRequestDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<>(new ResponseDto<>(-1, "유효성 검사 실패", errorMap), HttpStatus.BAD_REQUEST);
        }

        JoinResponseDto joinResponseDto = userService.join(joinRequestDto);
        return new ResponseEntity<>(new ResponseDto(1, "회원가입 성공", joinResponseDto), HttpStatus.CREATED);
    }
}

