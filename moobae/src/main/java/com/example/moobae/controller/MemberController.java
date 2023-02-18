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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public ResponseEntity<Objects> login(@RequestBody MemberDTO memberDTO, HttpServletRequest request) {
        try {
            memberService.checkMember(memberDTO);
            HttpSession session = request.getSession();
            session.setAttribute("memberDTO", memberDTO);
            return new ResponseEntity("로그인 성공", HttpStatus.SEE_OTHER); //나중에 로그인 성공 시 사이트 리다이렉션 예정
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/logout")
    public ResponseEntity<Objects> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        try {
            session.invalidate();
            return new ResponseEntity("로그아웃 성공", HttpStatus.SEE_OTHER);//나중에 로그아웃 성공 시 사이트 리다이렉션 예정
        }catch (NullPointerException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST); //익셉션 핸들러 적용 예정
        }
    }
}

