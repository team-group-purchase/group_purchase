package com.example.moobae.service;

import com.example.moobae.domain.mapper.MemberMapper;
import com.example.moobae.domain.member.Member;
import com.example.moobae.domain.member.dto.MemberDTO;
import com.example.moobae.domain.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
// @Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;
    private final Encryption encryption;

    public void signup(MemberDTO memberDTO){
        if(memberMapper.existUid(memberDTO.getUid()))
            throw new IllegalArgumentException("존재하는 유저 아이디입니다.");

        Member member = Member.MemberBuilder()
                        .uid(memberDTO.getUid())
                        .password(encryption.encryptHash(memberDTO.getPassword()))
                        .nickname(memberDTO.getNickname())
                        .email(memberDTO.getEmail())
                        .phoneNumber(memberDTO.getPhoneNumber())
                        .local(memberDTO.getLocal())
                        .activated(Boolean.TRUE)
                        .existed(Boolean.TRUE)
                        .updatedAt(LocalDateTime.now())
                        .createdAt(LocalDateTime.now())
                        .build();

        memberMapper.saveMember(member);
    }

    public MemberVO loadMember(MemberDTO memberDTO){
        return memberMapper.getMemberByUid(memberDTO.getUid());
    }

    public void checkMember(MemberDTO memberDTO) {
        if(memberMapper.invalidUid(memberDTO.getUid()))
            throw new IllegalArgumentException("존재하지 않는 유저 아이디입니다.");

        String savedPassword = memberMapper.getMemberByUid(memberDTO.getUid()).getPassword();

        if(!encryption.encryptCheck(memberDTO.getPassword() , savedPassword))
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
    }
}