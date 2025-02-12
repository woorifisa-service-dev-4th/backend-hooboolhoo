package dev.hooboolhoo.service;

import dev.hooboolhoo.model.Game;
import dev.hooboolhoo.model.GameCreator;
import dev.hooboolhoo.model.User;

import java.util.List;
import java.util.Scanner;

public class GameController {
    // List<Game> gameList;
    List<User> userList;
    Scanner sc = new Scanner(System.in);
    int input = -1;
    
    GameVotingApp gameVotingApp = new GameVotingApp();

    public void startGame() {
        System.out.println("🐯🔥🐯호불호🐯🔥🐯");

        UserListController userListController = new UserListController();
        // 유저 목록 로드하기 (더미 데이터)
         userListController.loadUserList();

        // Game List 가져오기
        // getGameList();

        CurrentUser currentUser = CurrentUser.getInstance();
        AuthManager authManager = new AuthManager(userListController, currentUser);

        while (true) {
            System.out.println("0. 종료 1. 회원가입 2. 로그인");
            System.out.print("입력: ");
            input = sc.nextInt();
            sc.nextLine(); // 개행 문자 제거

            switch (input) {
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                case 1:
                    System.out.println("[회원가입]");
                    authManager.signUp();
                    break;
                case 2:
                    System.out.println("[로그인]");
                    if (authManager.signIn() == null) {
                        System.out.println("로그인 실패! 다시 시도해주세요.");
                    }
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    break;
            }

            if (authManager.getIsSignIn()) {

                if (playGame(currentUser)) {
                    return;
                }
            }
        }
    }

    public boolean playGame(CurrentUser currentUser) {
        MyPageController myPageController = new MyPageController();

        while(true) {
            System.out.println("메뉴");
            System.out.println("0. 게임 종료 1. 호불호 게임하기 2. 게임 만들기 3. 마이페이지");
            System.out.print("입력: ");
            input = sc.nextInt();
            // sc.nextLine(); // 개행 문자 제거

            switch (input) {
                case 0:
                    System.out.println("게임을 종료합니다.");
                    return true;
                case 1:
                  System.out.println("[호불호 게임하기]");
                	gameVotingApp.startGame();
                    break;
                case 2:
                    // 게임 만들기: GameCreator를 이용해 vs 게임 생성
                    System.out.println("[게임 만들기]");
                    GameCreator gameCreator = new GameCreator();
                    Game newGame = gameCreator.createGame();
                    // 추가로 생성된 게임을 저장하거나 관리하는 로직이 있다면 작성
                    break;
                case 3:
                    if (myPageController.startMyPage(currentUser)) {
                        break;
                    } else {
                        return true;
                    }
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    break;
            }
        }
    }
}
