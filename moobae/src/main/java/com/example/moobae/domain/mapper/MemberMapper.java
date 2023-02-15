package com.example.moobae.domain.mapper;

import com.example.moobae.domain.member.Member;
import com.example.moobae.domain.member.MemberDTO;
import com.example.moobae.domain.member.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void saveMember(Member member);
    MemberVO loadMember(MemberDTO memberDTO);
}
