package com.example.moobae.controller;

import com.example.moobae.domain.member.dto.MemberDTO;
import com.example.moobae.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<Objects> signup(@RequestBody MemberDTO memberDTO) {
        try {
            memberService.signup(memberDTO);
            return new ResponseEntity("회원가입 성공", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Objects> login(@RequestBody MemberDTO memberDTO) {
        try {
            memberService.checkMember(memberDTO);
            return new ResponseEntity("로그인 성공", HttpStatus.SEE_OTHER); //나중에 로그인 성공 시 사이트 리다이렉션 예정
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

