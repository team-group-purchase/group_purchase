package com.example.moobae.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@Builder(builderMethodName = "MemberBuilder")
@Getter
@RequiredArgsConstructor
public class Member {
    private final Integer id;
    private final String uid; // 로그인 시 입력하는 id
    private final String password;
    private final String nickname;
    private final String email;
    private final String phoneNumber;
    private final String local;
    private final Boolean activated;
    private final Boolean existed;
    private final LocalDateTime updatedAt;
    private final LocalDateTime createdAt;

}