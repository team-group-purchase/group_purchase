package com.example.moobae.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private int id;

    private String identity;

    private String password;

    private String nickname;

    private String email;

    private String phoneNumber;

    private String local;

    private boolean activated;

    private boolean existed;

    private String created_at;

    private String updated_at;
}
