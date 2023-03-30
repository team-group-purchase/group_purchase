package com.example.moobae.service;

import com.example.moobae.domain.mapper.MemberMapper;
import com.example.moobae.domain.member.Member;
import com.example.moobae.domain.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;
    private final Encryption encryption;
    private final SessionService sessionService;

    public void signUp(MemberDto memberDto){
        if(memberMapper.existUid(memberDto.getUid()))
            throw new IllegalArgumentException("존재하는 유저 아이디입니다.");

        Member member = Member.MemberBuilder()
                        .uid(memberDto.getUid())
                        .password(encryption.encryptHash(memberDto.getPassword()))
                        .nickname(memberDto.getNickname())
                        .email(memberDto.getEmail())
                        .phoneNumber(memberDto.getPhoneNumber())
                        .local(memberDto.getLocal())
                        .activated(Boolean.TRUE)
                        .existed(Boolean.TRUE)
                        .updatedAt(LocalDateTime.now())
                        .createdAt(LocalDateTime.now())
                        .build();

        memberMapper.saveMember(member);
    }

    public void login(MemberDto memberDto) {
        if(memberMapper.invalidUid(memberDto.getUid()))
            throw new IllegalArgumentException("존재하지 않는 유저 아이디입니다.");

        String savedPassword = memberMapper.getMemberByUid(memberDto.getUid()).getPassword();

        if(!encryption.encryptCheck(memberDto.getPassword() , savedPassword))
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");

        sessionService.setSession(memberDto);
    }

    public void logout() {
        sessionService.invalidateSession();
    }
}