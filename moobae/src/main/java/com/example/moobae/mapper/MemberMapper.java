package com.example.moobae.mapper;

import com.example.moobae.dto.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void insert(Member member);
}
