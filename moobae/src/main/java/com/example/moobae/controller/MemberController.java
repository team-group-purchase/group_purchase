package com.example.moobae.controller;

import com.example.moobae.dto.Member;
import com.example.moobae.dto.MemberVO;
import com.example.moobae.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/sign-up")
    public void signup(@RequestBody Member member) {

        memberService.join(member);
    }

    @PostMapping("/sign-in")
    public boolean signIn(@RequestBody MemberVO memberVO) {
        if (memberService.checkMember(memberVO)) {
            return true;
        } else {
            return false;
        }
    }

}
