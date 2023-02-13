package com.example.moobae.domain.member;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@Getter //자바 reflection보기
@RequiredArgsConstructor
public class Member {
    private final int id;
    private final String identity;
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