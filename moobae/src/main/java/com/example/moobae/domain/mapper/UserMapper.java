package com.example.moobae.domain.mapper;

import com.example.moobae.domain.member.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void saveUser(Member member);
}
