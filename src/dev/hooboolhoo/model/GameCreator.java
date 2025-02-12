package dev.hooboolhoo.model;

import java.util.Scanner;

public class GameCreator {
    private Scanner scanner = new Scanner(System.in);

    public Game createGame() {
        Game newGame = new Game();
        
        // 게임 제목 입력
        System.out.print("게임 제목 : ");
        String title = scanner.nextLine();
        newGame.setGameTitle(title);
        
        // 게임 설명 입력
        System.out.print("게임 설명 : ");
        String description = scanner.nextLine();
        newGame.setSubTitle(description);
        
        // 게임 카테고리 입력
        System.out.print("게임 카테고리 : ");
        String category = scanner.nextLine();
        newGame.setCategory(category);
        
        // 선택지 2개 입력
        System.out.print("첫 번째 선택지를 입력하세요: ");
        String choice1 = scanner.nextLine();
        newGame.addChoice(new Choice(choice1));
        
        System.out.print("두 번째 선택지를 입력하세요: ");
        String choice2 = scanner.nextLine();
        newGame.addChoice(new Choice(choice2));
        
        // 생성된 게임 정보 출력
        System.out.println("\n 호불호 게임 생성 완료!");
        System.out.println("게임 제목: " + newGame.getGameTitle());
        System.out.println("게임 설명: " + newGame.getSubTitle());
        System.out.println("게임 카테고리: " + newGame.getCategory());
        System.out.println("선택지:");
        for (int i = 0; i < newGame.getChoices().size(); i++) {
            System.out.println("  " + (i + 1) + ". " + newGame.getChoices().get(i).getName());
        }
        
        return newGame;
    }
}
