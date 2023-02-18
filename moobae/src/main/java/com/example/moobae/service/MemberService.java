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
}