package dev.hooboolhoo.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private String gameTitle;
    private String subTitle;
    private String category;
    private List<Choice> choices; // 선택지 목록

    public Game() {
        choices = new ArrayList<>();
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
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public List<Choice> getChoice() {
        return choices;
    }
    
    public void setChoice(List<Choice> choices) {
        this.choices = choices;
    }
    
    public void addChoice(Choice choice) {
        this.choices.add(choice);
    }
}
