package dev.hooboolhoo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Game {
	private String author;
	private String category;
	
	private String gameThumbnail;

	private UUID id = UUID.randomUUID();
	private String gameTitle;
	private String subTitle;
	private int leftButtonCount = 0;
	private int rightButtonCount = 0;

	List<Choice> choices;

	List<Comment> comments;

	private int totalCount;
	
  public Game() {
        choices = new ArrayList<>();
    }
  
	public Game(String gameTitle, String gamethumbnail, String author, List<Choice> choices) {
		this.gameTitle = gameTitle;
        this.gameThumbnail = gameThumbnail;
        this.choices = choices;
        this.comments = new ArrayList<>();
		this.author = author;
    }

	public UUID getId() {
		return id;
	}

	//	public String getGameId() {
//		return gameId;
//	}

	public String getNickName() {
		return author;
	}
	
	public void setNickName(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
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

	public List<Choice> getChoices() {
		return choices;
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public void setChoices(List<Choice> choice) {
		this.choices = choices;
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
	
    
    public void addChoice(Choice choice) {
        this.choices.add(choice);
    }

	public void setAuthor(String author) {
		this.author = author;
	}
}
