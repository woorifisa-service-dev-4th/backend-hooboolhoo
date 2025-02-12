package dev.hooboolhoo.service;

import dev.hooboolhoo.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserListController {
    private List<User> userList = new ArrayList<User>();

    public void loadUserList() { // 더미데이터 주입
        User dummyUser1 = new User("papa021326@naver.com","eratchacha","990213");
        User dummyUser2 = new User("","","");
        User dummyUser3 = new User("","","");

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
