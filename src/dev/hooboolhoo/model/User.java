package dev.hooboolhoo.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String password;
    private String nickname;
    // private String profileImg;
    private List<String> testResults = new ArrayList<String>();
    private List<String> myTests = new ArrayList<String>();

    public User(String id, String password, String nickname, List<String> testResults, List<String> myTests) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.testResults = testResults;
        this.myTests = myTests;
    }

    public User(String id, String nickname, String password) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public List<String> getTestResults() {
        return testResults;
    }

    public List<String> getMyTests() {
        return myTests;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setTestResults(List<String> testResults) {
        this.testResults = testResults;
    }

    public void setMyTests(List<String> myTests) {
        this.myTests = myTests;
    }
}


