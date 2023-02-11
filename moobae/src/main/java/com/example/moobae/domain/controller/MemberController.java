package com.example.moobae.domain.controller;

import com.example.moobae.domain.member.Member;
import com.example.moobae.domain.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller //view를 반환
//@RequestMapping("/signUp") //요청받을 url
@RequiredArgsConstructor //final 붙은 메소드or필드or클래스에 대한 생성자 자동생성
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("/signUp")
    public String signUpForm() {
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(Member member) {
        memberService.joinMember(member);
        return "redirect:login";
    }




}

