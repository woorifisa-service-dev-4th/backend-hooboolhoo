package dev.hooboolhoo.model;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private String author;
	private String category;
	
	private String gameThumbnail;
	
	private String gameTitle;
	private String subTitle;
	private int leftButtonCount = 0;
	private int rightButtonCount = 0;
	
	List<Choice> choice;
	List<Comment> comments;

	private int totalCount;
	
	public Game(String gameTitle, String gamethumbnail) {
		this.gameTitle = gameTitle;
        this.gameThumbnail = gameThumbnail;
        this.choice = choice;
        this.comments = new ArrayList<>();
    }

	public String getGameId() {
		
	}

	public String getNickName() {
		return author;
	}
	
	public void setNickName(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getGamethumbnail() {
		return gameThumbnail;
	}

	public void setGamethumbnail(String gamethumbnail) {
		this.gameThumbnail = gamethumbnail;
	}

	public String getGameTitle() {
		return gameTitle;
	}

	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public List<Choice> getChoice() {
		return choice;
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public void setChoice(List<Choice> choice) {
		this.choice = choice;
	}


	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	// 투표 수 증가 메서드 
	public void voteLeft() {
        leftButtonCount++;
    }

    public void voteRight() {
        rightButtonCount++;
    }

    // 투표 수 조회 메서드
    public int getLeftButtonCount() {
        return leftButtonCount;
    }

    public int getRightButtonCount() {
        return rightButtonCount;
    }
	
    // 댓글 추가 메서드
	public void addComment(Comment comment) {
		comments.add(comment);
	}
	
	
	
}
