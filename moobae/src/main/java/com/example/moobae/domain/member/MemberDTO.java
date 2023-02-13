package com.example.moobae.domain.member;

import lombok.Getter;

@Getter
public class MemberDTO {
    private String identity;
    private String password;
    private String nickname;
    private String email;
    private String phoneNumber;
    private String local;

    private MemberDTO(){}

}
