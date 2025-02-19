package dev.hooboolhoo.service;

import dev.hooboolhoo.model.User;

import java.util.List;

public class AuthManager {
    private final UserListController userListController;
    private final CurrentUser currentUser = CurrentUser.getInstance();
    private boolean isSignIn = false;

    public AuthManager(UserListController userListController) {
        this.userListController = userListController;
    }

    public boolean getIsSignIn() {
        return isSignIn;
    }

    public boolean isValidUser(String id, String password) {
        List<User> userList = userListController.getUserList();
        
        for (User user : userList) {
            if (id.equals(user.getId()) && password.equals(user.getPassword())) {
                return true; // 유효한 사용자 true
            }
        }
        return false; // 존재하지 않는 사용자인가? or 비밀번호 불일치인지?
    }
    public Boolean signInWithoutScanner(String id, String password) {
        if (isValidUser(id, password)) {
            System.out.printf("로그인 성공! 안녕하세요, %s 님!\n", id);
            isSignIn = true;
            return true;
        } else {
            System.out.println("아이디 또는 비밀번호가 올바르지 않습니다.");
            return false;
        }
    }
}
