package com.example.moobae.domain.service;

import com.example.moobae.domain.mapper.MemberMapper;
import com.example.moobae.domain.member.Member;
import com.example.moobae.domain.member.MemberDTO;
import com.example.moobae.domain.member.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;
    private final Encryption encryption;

    public void joinMember(MemberDTO memberDTO){
        Member member = Member.MemberBuilder()
                        .identity(memberDTO.getIdentity())
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

    public boolean checkMember(MemberDTO memberDTO, MemberVO memberVO) {
        return encryption.encryptCheck(memberDTO.getPassword() , memberVO.getPassword());
    }
}