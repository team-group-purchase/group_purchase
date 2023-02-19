package com.example.moobae.mapper;

import com.example.moobae.dto.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void insert(Member member);

    Member getUserInfo(String identity);

    Integer checkDuplicate(String identity);
}
