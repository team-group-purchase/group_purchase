package com.example.moobae.controller;

import com.example.moobae.domain.member.dto.MemberDTO;
import com.example.moobae.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;


    @PostMapping("/sign-up")
    public ResponseEntity<Objects> signUp(@RequestBody MemberDTO memberDTO) {
        memberService.signUp(memberDTO);
        return new ResponseEntity("회원가입 성공", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Objects> login(@RequestBody MemberDTO memberDTO) {
        memberService.login(memberDTO);
        return new ResponseEntity("로그인 성공", HttpStatus.SEE_OTHER); //나중에 로그인 성공 시 사이트 리다이렉션 예정
    }

    @PostMapping("/logout")
    public ResponseEntity<Objects> logout() {
        memberService.logout();
        return new ResponseEntity("로그아웃 성공", HttpStatus.SEE_OTHER);//나중에 로그아웃 성공 시 사이트 리다이렉션 예정
    }
}

