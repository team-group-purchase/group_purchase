package com.example.moobae.domain.service;

import com.example.moobae.domain.mapper.MemberMapper;
import com.example.moobae.domain.member.Member;
import com.example.moobae.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;
    private final MemberRepository memberRepository;

    @Transactional
    public void joinMember(Member member){
        //member.setPassword(member.getPassword()); //암호화 추후 추가
        /*member.setEmail("email1");
        member.setPhoneNumber("Phone1");
        member.setLocal("local1");
        member.setActivated(Boolean.TRUE);
        member.setExisted(Boolean.TRUE);
        member.setCreatedAt(LocalDateTime.now());
        member.setUpdatedAt(LocalDateTime.now());
        memberRepository.save(member);
        memberMapper.saveMember(member);*/

    }
}