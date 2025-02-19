package dev.hooboolhoo.test;
import static org.junit.jupiter.api.Assertions.*;

import dev.hooboolhoo.model.Game;
import dev.hooboolhoo.model.GameCreator;
import dev.hooboolhoo.model.GameList;
import dev.hooboolhoo.model.Choice;
import dev.hooboolhoo.model.User;
import dev.hooboolhoo.service.CurrentUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GameCreatorTest {

    private GameCreator gameCreator;
    private CurrentUser currentUser;
    private GameList gameList;
    private User user;

    @BeforeEach
    void setUp() {
        // 실제 CurrentUser 객체 생성
        CurrentUser currentUser = new CurrentUser();
        user = new User("youngchan468@naver.com", "123456", "testUser");
        currentUser.setUser(user);

        // 실제 GameList 객체 생성
        gameList = new GameList();

        // GameCreator 초기화
        gameCreator = new GameCreator();
    }

    @Test
    void testCreateGame() {
        // 게임 생성 시도
        Game game = gameCreator.createGame();

        // 게임 제목 및 생성된 게임의 검증
        assertEquals("게임 제목", game.getGameTitle());
        assertEquals("게임 설명", game.getSubTitle());
        assertEquals("testUser", game.getAuthor());
        assertEquals(2, game.getChoices().size());
    }
}
