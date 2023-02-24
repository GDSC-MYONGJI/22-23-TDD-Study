package com.example.tdd_project.chapter7;

public class UserRegister {
    // 생략
    public void register(String id, String pw, String email) {
        // 생략
        userRepository.save(new User(id, pw, email));

        emailNotifier.sendRegisterEmail(email);
    }
}
