package com.example.moobae.domain.controller;

import com.example.moobae.domain.member.Member;
import com.example.moobae.domain.member.MemberRepository;
import com.example.moobae.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //view를 반환
//@RequestMapping("/signUp") //요청받을 url
@RequiredArgsConstructor //final 붙은 메소드or필드or클래스에 대한 생성자 자동생성
public class MemberController {
    @Autowired
    UserService userService;

    @GetMapping("/signUp")
    public String signUpForm() {
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(Member member) {
        userService.joinUser(member);
        return "redirect:login";
    }




}

