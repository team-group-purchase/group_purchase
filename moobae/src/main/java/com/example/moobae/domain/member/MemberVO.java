package com.example.moobae.domain.member;

import lombok.Getter;

@Getter
public class MemberVO {
    private String identity;
    private String password;

    private MemberVO(){}
}
