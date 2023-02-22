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

    @PostMapping("/sign-up")
    public ResponseEntity<Objects> signUp(@RequestBody MemberDTO memberDTO) {
        try {
            memberService.signUp(memberDTO);
            return new ResponseEntity("회원가입 성공", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

