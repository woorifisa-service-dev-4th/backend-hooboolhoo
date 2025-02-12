package dev.hooboolhoo.service;

import dev.hooboolhoo.model.User;

import java.util.List;
import java.util.Scanner;

public class GameController {
//    List<Game> gameList;
    List<User> userList;
    Scanner sc = new Scanner(System.in);
    int input = -1;
    
    GameVotingApp gameVotingApp = new GameVotingApp();

    public void startGame() {
        System.out.println("🐯🔥🐯호불호🐯🔥🐯");

        // User List 가져오기
        // getUserList();

        // Game List 가져오기
        // getGameList();

        AuthManager authManager = new AuthManager();

        while(true) {
            System.out.println("0. 종료 1. 회원가입 2. 로그인");
            System.out.print("입력: ");
            input = sc.nextInt();

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
                    if (!authManager.signIn()) {
                        System.out.println("로그인 실패! 다시 시도해주세요.");
                    }
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    break;
            }

            if (authManager.getIsSignIn()) {
                if (playGame()) {
                    return;
                }
            }
        }
    }

    public boolean playGame() {
        while(true) {
            System.out.println("메뉴");
            System.out.println("0. 게임 종료 1. 호불호 게임하기 2. 게임 만들기 3. 마이페이지");
            System.out.print("입력: ");
            input = sc.nextInt();

            switch (input) {
                case 0:
                    System.out.println("게임을 종료합니다.");
                    return true;
                case 1:
                	gameVotingApp.startGame();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    break;
            }

        }
    }
}
