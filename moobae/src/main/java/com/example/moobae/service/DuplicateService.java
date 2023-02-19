package com.example.moobae.service;

import com.example.moobae.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DuplicateService {
    private final MemberMapper memberMapper;

    public boolean checkDuplicatedId(String identity) {
        Integer check = memberMapper.checkDuplicate(identity);
        if (check != null) {
            return false;
        } else {
            return true;
        }
    }
}
