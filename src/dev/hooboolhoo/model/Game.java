package dev.hooboolhoo.model;

import java.util.List;

public class Game {
	private String gameId;
	private String nickname;
	private String category;
	
	private String gamethumbnail;
	
	private String gameTitle;
	private String subTitle;
	
	List<Choice> choice;
	List<Comments> comments;

	int totalCount;

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getNickName() {
		return nickname;
	}
	
	public void setNickName(String nickName) {
		this.nickname = nickName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getGamethumbnail() {
		return gamethumbnail;
	}

	public void setGamethumbnail(String gamethumbnail) {
		this.gamethumbnail = gamethumbnail;
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
	
	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
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
	
	
	
}
