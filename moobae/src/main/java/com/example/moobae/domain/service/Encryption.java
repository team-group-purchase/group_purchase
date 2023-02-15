package com.example.moobae.domain.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class Encryption {
    public String encryptHash(String password) { return BCrypt.hashpw(password, BCrypt.gensalt());}
    public boolean encryptCheck(String password, String hashed) { return BCrypt.checkpw(password, hashed); }
}
