package com.example.moobae.service;


import com.example.moobae.dto.Member;
import com.example.moobae.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberMapper memberMapper;

    @Override
    public void join(Member member) {
        Member newMember = Member.builder()
                .identity(member.getIdentity())
                .password(member.getPassword())
                .nickname(member.getNickname())
                .email(member.getEmail())
                .phoneNumber(member.getPhoneNumber())
                .local(member.getLocal())
                .activated(member.isActivated())
                .existed(member.isExisted())
                .created_at(member.getCreated_at())
                .updated_at(member.getUpdated_at())
                .build();

        memberMapper.insert(newMember);
    }
}
