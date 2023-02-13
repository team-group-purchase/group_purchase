package com.example.moobae.domain.controller;

import com.example.moobae.domain.member.Member;
import com.example.moobae.domain.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public String signUp(@RequestBody Member member) { //쿼리스트링(url), json, html form방식
        memberService.joinMember(member);
        return "redirect:login";
    }
}

