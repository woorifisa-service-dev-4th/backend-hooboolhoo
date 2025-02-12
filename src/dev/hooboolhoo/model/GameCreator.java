package dev.hooboolhoo.model;

import java.util.Scanner;

public class GameCreator {

    private Scanner scanner = new Scanner(System.in);

    public Game createGame() {
        Game newGame = new Game();

        // 게임 제목 입력
        System.out.print("게임 제목을 입력하세요: ");
        String title = scanner.nextLine();
        newGame.setGameTitle(title);

        // 부가설명을 입력하고
        System.out.print("게임 부가설명을 입력하세요: ");
        String subTitle = scanner.nextLine();
        newGame.setSubTitle(subTitle);

        // 카테고리 입력하고
        System.out.print("게임 카테고리를 입력하세요: ");
        String category = scanner.nextLine();
        newGame.setCategory(category);

        // 게임 썸네일 선택하고
        System.out.print("게임 썸네일을 입력/선택하세요: ");
        String thumbnail = scanner.nextLine();
        newGame.setGamethumbnail(thumbnail);

        // 게임 생성 완료 출력이된다
        System.out.println("호불호 게임 생성 완료!");

        // 생성된 게임 정보 출력하게 구현
        System.out.println("게임 썸네일 URL: " + newGame.getGamethumbnail());
        System.out.println("생성된 게임 정보:");
        System.out.println("게임 제목: " + newGame.getGameTitle());
        System.out.println("게임 서브타이틀: " + newGame.getSubTitle());
        System.out.println("게임 카테고리: " + newGame.getCategory());

        return newGame;
    }
}
