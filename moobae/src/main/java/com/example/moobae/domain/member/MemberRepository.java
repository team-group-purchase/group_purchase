package com.example.moobae.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private static Map<Integer,Member> store = new ConcurrentHashMap<>();
    private static int sequence = 1;

    private static final MemberRepository instance = new MemberRepository();
    public static MemberRepository getInstance() {return instance; }


    public Member save(Member member) {
        member.setId(sequence++);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(int id) {return store.get(id); }
    public List<Member> findAll() {return new ArrayList<>(store.values()); }

    public void clearStore() {store.clear(); }
}

