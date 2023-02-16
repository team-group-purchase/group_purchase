package com.example.moobae.service;


import com.example.moobae.dto.Member;
import com.example.moobae.dto.MemberVO;
import com.example.moobae.mapper.MemberMapper;
import com.example.moobae.utils.Bcrypt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;
    private final Bcrypt bcrypt;
    private final DuplicateService duplicateService;

    public void join(Member member) {
        Member newMember = Member.builder()
                .identity(member.getIdentity())
                .password(bcrypt.hashPassword(member.getPassword()))
                .nickname(member.getNickname())
                .email(member.getEmail())
                .phoneNumber(member.getPhoneNumber())
                .local(member.getLocal())
                .build();

        if (duplicateService.checkDuplicatedId(newMember.getIdentity())) {
            memberMapper.insert(newMember);
        } else {
            //아이디가 중복되었을 경우 로직 필요
        }
    }

    public boolean checkMember(MemberVO memberVO) {
        Member member = memberMapper.getUserInfo(memberVO.getIdentity());
        if (member == null) {
            return false;
        } else {
            return bcrypt.checkPassword(memberVO.getPassword(), member.getPassword());
        }
    }

}
