package dev.hooboolhoo.model;

import java.time.LocalDateTime;

public class Comment {
	private String writer;	// 댓글 작성자 닉네임
	private String content;	// 댓글 내용
	private boolean choiceType;	// 선택 타입
	private LocalDateTime date;	// 댓글 작성 날짜
	
	public Comment(String writer, String content, boolean choiceType) {
		this.writer = writer;
		this.content = content;
		this.choiceType = choiceType;
		this.date = LocalDateTime.now();
	}
	
	// 댓글 작성자 닉네임
	public String getWriter() { 
		return writer; 
	}
	
	// 댓글 내용
	public String getContent() { 
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	// 선택 타입
	public boolean getChoiceType() { 
		return choiceType; 
	}

	public void setChoiceType(boolean choiceType) {
		this.choiceType = choiceType;
	}

	// 댓글 작성 날짜
	public LocalDateTime getDate() { 
		return date; 
	}
	
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	

	
}