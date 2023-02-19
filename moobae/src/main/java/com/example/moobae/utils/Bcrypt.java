package com.example.moobae.utils;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class Bcrypt {

    public String hashPassword(String pw) {
        return BCrypt.hashpw(pw, BCrypt.gensalt());
    }

    public boolean checkPassword(String password, String passwordHashed) {
        return BCrypt.checkpw(password, passwordHashed);
    }

}
