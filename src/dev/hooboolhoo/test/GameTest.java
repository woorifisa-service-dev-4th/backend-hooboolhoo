package dev.hooboolhoo.test;
import static org.junit.jupiter.api.Assertions.*;

import dev.hooboolhoo.model.User;
import dev.hooboolhoo.service.AuthManager;
import dev.hooboolhoo.service.UserListController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class AuthManagerTest {
    private AuthManager authManager;
    private UserListController userListController;
    private List<User> userList;

    @BeforeEach
    void setUp() {
        // 실제 사용자 목록 설정
        userList = new ArrayList<>();
        userList.add(new User("youngchan468@naver.com","zerocold","123456"));
        
        // 실제 UserListController 초기화
        userListController = new UserListController(userList);
        
        // 실제 AuthManager 초기화
        authManager = new AuthManager(userListController);
    }
    
    @Test
    void testSignIn() {
        // 로그인 시도
        boolean isSignIn = authManager.signIn();
        
        // 로그인 성공 여부 확인
        assertTrue(isSignIn);
    }
    
    @Test
    void testSignInInvalidId() {
        // 존재하지 않는 아이디로 로그인 시도
        userList.clear();
        boolean isSignIn = authManager.signIn();
        
        // 로그인 실패 확인
        assertFalse(isSignIn);
    }
}
