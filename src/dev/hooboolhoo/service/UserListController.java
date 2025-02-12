package dev.hooboolhoo.service;

import dev.hooboolhoo.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserListController {
    private List<User> userList = new ArrayList<User>();

    public void loadUserList() { // 더미데이터 주입
        User dummyUser1 = new User("papa021326@naver.com","eratchacha","990213");
        User dummyUser2 = new User("dlwjdals0726@gmail.com","jeongmin07262","1234");
        User dummyUser3 = new User("yyc0026@naver.com","yyc0026","1234");

        userList.add(dummyUser1);
        userList.add(dummyUser2);
        userList.add(dummyUser3);
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }
}
