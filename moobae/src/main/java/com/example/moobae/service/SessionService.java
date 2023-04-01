package com.example.moobae.service;

import com.example.moobae.domain.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;
import static com.example.moobae.domain.SessionConst.ID;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final HttpSession httpSession;

    public void setSession(Integer id) {
        httpSession.setAttribute(ID, id);
    }

    public void invalidateSession() {
        httpSession.invalidate();
    }
}
