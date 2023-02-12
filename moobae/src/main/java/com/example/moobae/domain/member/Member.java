package com.example.moobae.domain.member;

import lombok.Data;

@Data //어떤걸 방식으로 할 지 몰라서 일단 @Data 어노테이션 사용
public class Member {
    private Integer id;
    private String identity;
    private String password;
    private String nickname;
    private String email;
    private String phoneNumber;
    private String local;
    private Boolean activated;
    private Boolean existed;
    private String updated_at;
    private String created_at;

}