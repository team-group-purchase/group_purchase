package com.example.moobae.controller;

import com.example.moobae.domain.member.dto.MemberDto;
import com.example.moobae.service.MemberService;
import lombok.RequiredArgsConstructor;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.CREATED;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/sign-up")
    public ResponseEntity<Objects> signUp(@RequestBody MemberDto memberDto) {
        memberService.signUp(memberDto);
        return new ResponseEntity("회원가입 성공", CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Objects> login(@RequestBody MemberDto memberDto) {
        memberService.login(memberDto);
        return new ResponseEntity("로그인 성공", OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<Objects> logout() {
        memberService.logout();
        return new ResponseEntity("로그아웃 성공", OK);
    }
}

