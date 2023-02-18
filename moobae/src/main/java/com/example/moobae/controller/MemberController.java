package com.example.moobae.controller;

import com.example.moobae.domain.mapper.MemberMapper;
import com.example.moobae.domain.member.dto.MemberDTO;
import com.example.moobae.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper memberMapper;
    @GetMapping("/sign-up")
    public ResponseEntity<Objects> signUpForm() {
        return new ResponseEntity("Sign Up" ,HttpStatus.OK);
    }
    @PostMapping("/sign-up")
    public ResponseEntity<Objects> signUp(@RequestBody MemberDTO memberDTO) {
        memberService.joinMember(memberDTO);
        return new ResponseEntity("Sign Up Success!" ,HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Objects> login(@RequestBody MemberDTO memberDTO) {
        if (memberService.checkMember(memberDTO , memberMapper.loadMember(memberDTO)))
            return new ResponseEntity("Login Success!" , HttpStatus.OK);
        else
            return new ResponseEntity("Login Failure!" , HttpStatus.BAD_REQUEST);
    }
}

