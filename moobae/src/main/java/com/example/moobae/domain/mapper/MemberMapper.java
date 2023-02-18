package com.example.moobae.domain.mapper;

import com.example.moobae.domain.member.Member;
import com.example.moobae.domain.member.dto.MemberDTO;
import com.example.moobae.domain.member.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void saveMember(Member member);
    MemberVO loadMember(MemberDTO memberDTO);
}
