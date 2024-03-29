package com.example.moobae.domain.member.dto;

import lombok.Getter;

@Getter
public class MemberDTO {
    private String uid;
    private String password;
    private String nickname;
    private String email;
    private String phoneNumber;
    private String local;

    private MemberDTO(){}

}
