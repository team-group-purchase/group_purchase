package com.example.moobae.domain.service;

import com.example.moobae.domain.mapper.MemberMapper;
import com.example.moobae.domain.member.Member;
import com.example.moobae.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class MemberService {
    // 회원가입 시 저장시간을 넣어줄 DateTime형
    SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);

    @Autowired
    MemberMapper memberMapper;
    @Autowired
    MemberRepository memberRepository;

    @Transactional
    public void joinMember(Member member){
        //member.setPassword(member.getPassword()); //암호화 추후 추가
        member.setEmail("email1");
        member.setPhoneNumber("Phone1");
        member.setLocal("local1");
        member.setActivated(Boolean.TRUE);
        member.setExisted(Boolean.TRUE);
        member.setCreated_at(localTime);
        member.setUpdated_at(localTime);
        memberRepository.save(member);
        memberMapper.saveMember(member);
    }
}