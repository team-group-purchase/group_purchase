package com.example.moobae.domain.controller;

import com.example.moobae.domain.member.MemberDTO;
import com.example.moobae.domain.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller //view를 반환
@RequestMapping("/sign-up") //요청받을 url
@RequiredArgsConstructor
public class MemberController {
    @Autowired
    MemberService memberService;
    @GetMapping()
    public String signUpForm() {
        return "sign-up";
    }
    @PostMapping()
    public ResponseEntity<Objects> signUp(@RequestBody MemberDTO memberDTO) { //쿼리스트링(url), json, html form방식
        memberService.joinMember(memberDTO);
        return new ResponseEntity("Success!" ,HttpStatus.OK);
    }
}

