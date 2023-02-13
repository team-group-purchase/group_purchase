package com.example.moobae.domain.service;

import com.example.moobae.domain.mapper.MemberMapper;
import com.example.moobae.domain.member.Member;
import com.example.moobae.domain.member.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;

    @Transactional
    public void joinMember(MemberDTO memberDTO){
        Member member = Member.MemberBuilder()
                        .identity(memberDTO.getIdentity())
                        .password(memberDTO.getPassword())
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