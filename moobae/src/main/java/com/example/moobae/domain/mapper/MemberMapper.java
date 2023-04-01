package com.example.moobae.domain.mapper;

import com.example.moobae.domain.member.Member;
import com.example.moobae.domain.member.vo.MemberVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void saveMember(Member member);
    MemberVo getMemberByUid(String uid);
    boolean invalidUid(String uid);
    boolean existUid(String uid);
    Integer getId(String uid);
}
