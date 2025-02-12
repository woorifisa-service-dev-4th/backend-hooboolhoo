package dev.hooboolhoo.service;

import java.util.List;
import java.util.Scanner;

public class MyPageController {
    private Scanner sc = new Scanner(System.in);

    public boolean startMyPage(CurrentUser currentUser) {
        String nickname = currentUser.getUser().getNickname();
        String id = currentUser.getUser().getId();
        String password = currentUser.getUser().getPassword();
        List<String> testResults = currentUser.getUser().getTestResults();
        List<String> myTests = currentUser.getUser().getMyTests();

        System.out.printf("%s님의 마이페이지\n", nickname);
        int input = -1;
        while(true) {
            System.out.println("0. 상위 페이지로 이동 1. 내가 한 게임 확인하기 2. 내가 만든 게임 확인하기 3. 프로그램 종료");

            switch(input) {
                case 0:
                    System.out.println("상위 페이지로 이동합니다.");
                    return true;
                case 1:
                    System.out.println("[내가 한 게임들]");
                    showTestResults(currentUser);
                    break;
                case 2:
                    System.out.println("[내가 만든 게임들]");
                    showTests(currentUser);
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    return false;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요");
                    break;
            }
        }
    }

    private void showTestResults(CurrentUser currentUser) {
        List<String> testResults = currentUser.getUser().getTestResults();

        /*
        for (Game game: gameList) {
            if (game.getTitle().equals(testResults[ind]) {
               
        }
         */

    }

    private void showTests(CurrentUser currentUser) {
        List<String> myTests = currentUser.getUser().getMyTests();
    }
}
