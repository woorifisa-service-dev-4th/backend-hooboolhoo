package dev.hooboolhoo.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dev.hooboolhoo.service.AuthManager;
import dev.hooboolhoo.service.UserListController;
import dev.hooboolhoo.model.User;

public class LoginTest {
    private AuthManager authManager;
    private UserListController userListController;

    @Before
    public void setUp() {
        // dummyUser3만 포함된 유저 리스트 생성
        List<User> dummyUsers = new ArrayList<>();
        dummyUsers.add(new User("youngchan468@naver.com", "zerocold", "123456")); // dummyUser3 추가

        userListController = new UserListController(dummyUsers);
        authManager = new AuthManager(userListController);
    }

    @Test
    public void testValidSignInWithDummyUser3() {
        // 올바른 ID & 비밀번호 사용하여 로그인
        boolean result = authManager.signInWithoutScanner("youngchan468@naver.com", "123456");
        assertTrue(result); // 로그인 성공 여부 확인
    }

    @Test
    public void testInvalidSignIn() {
        // 존재하지 않는 사용자 ID & 비밀번호 사용하여 로그인 실패 테스트
        boolean result = authManager.signInWithoutScanner("unknown123@naver.com", "324965465");
        assertFalse(result); // 로그인 실패 확인
    }

    @Test
    public void testWrongPassword() {
        // 존재하는 아이디지만 잘못된 비밀번호 입력하여 로그인 실패 테스트
        boolean result = authManager.signInWithoutScanner("youngchan468@naver.com", "3212432525");
        assertFalse(result); // 로그인 실패 확인
    }

    @Test
    public void testIsValidUserWithCorrectCredentials() {
        // 유효한 사용자 확인 테스트
        boolean result = authManager.isValidUser("youngchan468@naver.com", "123456");
        assertTrue(result); // 존재하는 계정이어야 함
    }

    @Test
    public void testIsValidUserWithWrongPassword() {
        // 비밀번호가 틀린 경우
        boolean result = authManager.isValidUser("youngchan468@naver.com", "wrongpass");
        assertFalse(result);
    }

    @Test
    public void testIsValidUserWithNonExistentUser() {
        // ❌ 존재하지 않는 사용자
        boolean result = authManager.isValidUser("nonexistent@naver.com", "password123");
        assertFalse(result);
    }
}
