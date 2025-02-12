package dev.hooboolhoo.model;

public class User {
    private String id;
    private String password; // TODO: Java Security
    private String nickname;
    // private String profileImg;
    private String[] testResults;
    private String[] myTests;

    public User(String[] testResults, String id, String password, String nickname, String[] myTests) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.testResults = testResults;
        this.myTests = myTests;
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

    public String[] getTestResults() {
        return testResults;
    }

    public String[] getMyTests() {
        return myTests;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setTestResults(String[] testResults) {
        this.testResults = testResults;
    }

    public void setMyTests(String[] myTests) {
        this.myTests = myTests;
    }
}