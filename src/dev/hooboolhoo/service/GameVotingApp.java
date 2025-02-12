package dev.hooboolhoo.service;

import java.util.List;
import java.util.Scanner;

import dev.hooboolhoo.model.Comment;
import dev.hooboolhoo.model.Game;
import dev.hooboolhoo.model.GameList;

public class GameVotingApp {
    Scanner sc = new Scanner(System.in);
    private GameList gameList;
    
    public GameVotingApp() {
        this.gameList = new GameList(); 
    }
    
 // GameVotingApp 시작 시 실행되는 메서드
    public void startGame() { 
        System.out.println("호불호 게임을 시작합니다.");

        displayGameList();
        int selectedGameIndex = getSelectedGameIndex();
        if (selectedGameIndex == -1) return;

        Game selectedGame = gameList.getGame(selectedGameIndex);

        displayGameDetails(selectedGame);
        displayComments(selectedGame);

        boolean choiceType = handleButtonSelection(selectedGame);

        addComment(selectedGame, choiceType);

        displayGameDetails(selectedGame);
        displayComments(selectedGame);
    }

    // 게임 리스트를 출력하는 메서드
    private void displayGameList() {
        System.out.println("===== 게임 리스트 =====");
        List<Game> games = gameList.getGameList();
        for (int i = 0; i < games.size(); i++) {
            System.out.println((i + 1) + ". " + games.get(i).getGameTitle());
        }
    }

    // 게임 번호 선택
    private int getSelectedGameIndex() {
        System.out.print("게임을 선택하세요 (번호를 입력해주세요): ");
        int selectedGameIndex = sc.nextInt() - 1;

        if (selectedGameIndex >= 0 && selectedGameIndex < gameList.getGameList().size()) {
            return selectedGameIndex;
        } else {
            System.out.println("잘못된 게임 번호입니다.");
            return -1;
        }
    }

    // 선택된 게임의 타이틀과 썸네일 출력
    private void displayGameDetails(Game game) {
        System.out.println("\n=== " + game.getGameTitle() + " ===");
        System.out.println("타이틀: " + game.getGameTitle());
        System.out.println("썸네일: " + game.getGamethumbnail());
        System.out.println("=====================");
    }

    // 게임의 choice버튼을 선택하는 메서드
    private boolean handleButtonSelection(Game selectedGame) {
        String[] options = getGameOptions(selectedGame);
        System.out.println(options[0] + "(L) " + options[1] + "(R)");

        System.out.print("\n버튼을 선택하세요 (L/R): ");
        String buttonChoice = sc.next();
        boolean choiceType = false;
        
        if (buttonChoice.equalsIgnoreCase("L")) {
            selectedGame.voteLeft();
            choiceType = true;
            System.out.println("왼쪽 버튼을 선택했습니다.");
        } else if (buttonChoice.equalsIgnoreCase("R")) {
            selectedGame.voteRight();
            choiceType = false;
            System.out.println("오른쪽 버튼을 선택했습니다.");
        } else {
            System.out.println("잘못된 입력입니다.");
        }

        System.out.println("\n현재 버튼 클릭 수");
        System.out.println("왼쪽 버튼 (L) 클릭 수: " + selectedGame.getLeftButtonCount());
        System.out.println("오른쪽 버튼 (R) 클릭 수: " + selectedGame.getRightButtonCount());
        
        return choiceType;
    }

    // 게임 제목에서 'vs'를 기준으로 분리하는 메서드
    private String[] getGameOptions(Game selectedGame) {
        return selectedGame.getGameTitle().split(" vs ");
    }

    // 댓글 추가 메서드
    private void addComment(Game selectedGame, boolean choiceType) {
        System.out.print("\n댓글을 추가하려면 (Y/N): ");
        String addCommentChoice = sc.next();
        if (addCommentChoice.equalsIgnoreCase("Y")) {
            System.out.print("추가할 댓글을 입력하세요: ");
            sc.nextLine();  
            String newComment = sc.nextLine();
            
            Comment comment = new Comment("User", newComment, choiceType);
            selectedGame.addComment(comment);
            System.out.println("댓글이 정상적으로 등록되었습니다.");
        }
    }

    // 댓글 출력 메서드
    private void displayComments(Game selectedGame) {
        System.out.println("=== 댓글 목록 ===");
        List<Comment> comments = selectedGame.getComments();
        if (comments.isEmpty()) {
            System.out.println("아직 댓글이 없습니다.");
        } else {
            for (int i = 0; i < comments.size(); i++) {
                System.out.println((i + 1) + ". " + comments.get(i).getContent());
            }
        }
    }
}
