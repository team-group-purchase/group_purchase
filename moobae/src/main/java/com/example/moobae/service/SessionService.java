package com.example.moobae.service;

import com.example.moobae.domain.mapper.MemberMapper;
import com.example.moobae.domain.member.Member;
import com.example.moobae.domain.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

import static com.example.moobae.domain.SessionConst.MEMBER;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final HttpSession httpSession;

    public void setSession(MemberDto memberDto) {
        httpSession.setAttribute(MEMBER, memberDto);
    }

    public void invalidateSession() {
        httpSession.invalidate();
    }
}
