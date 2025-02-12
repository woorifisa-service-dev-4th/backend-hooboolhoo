package dev.hooboolhoo.service;

import dev.hooboolhoo.model.Choice;
import dev.hooboolhoo.model.Comment;
import dev.hooboolhoo.model.Game;

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

    private void showGame(Game game) {
        System.out.printf("게임명 : %s\n", game.getGameTitle());
        System.out.printf("게임 설명: %s\n", game.getSubTitle());
        // System.out.printf("게임 제작자: %s\n", game.getAuthor());
        System.out.printf("게임 카테고리: %s\n", game.getCategory());

        System.out.println("게임 결과");
        System.out.println("---------------------------------");
        List <Choice> choices = game.getChoices();
        System.out.printf("선택 1: %s / %s회 선택됨.\n", choices.get(0).getName(), choices.get(0).getCount());
        System.out.printf("선택 2: %s / %s회 선택됨.\n", choices.get(1).getName(), choices.get(1).getCount());

        System.out.println("댓글 목록");
        System.out.println("---------------------------------");
        for (Comment comment : game.getComments()) {
            showChoice(comment);
        }
    }

    private void showChoice(Comment comment) {
        String tab = "";
        if (comment.getChoiceType()) {
            tab = "             ";
        }

        System.out.printf("%s 작성자: %s\n", tab, comment.getWriter());
        System.out.printf("%s 내용: %s\n", tab, comment.getContent());
        System.out.printf("%s 작성일자: %s\n", tab, comment.getDate().toString());
    }

    private void showTestResults(CurrentUser currentUser) {
        List<String> testResults = currentUser.getUser().getTestResults();
        int ind = 0;

        /*
        for (Game game: gameList) {
            if (game.getTitle().equals(testResults[ind++]) {
               showGame(game);
        }
         */

    }

    private void showTests(CurrentUser currentUser) {
        List<String> myTests = currentUser.getUser().getMyTests();
        int ind = 0;

        /*
        for (Game game: gameList) {
            if (game.getAuthor().equals(myTests[ind++]) {
               showGame(game);
        }
         */
    }
}
