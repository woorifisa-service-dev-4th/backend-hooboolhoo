package dev.hooboolhoo.model;

import java.util.ArrayList;
import java.util.List;

public class GameList {
    private List<Game> gameList = new ArrayList<Game>();
    private static GameList instance;

    public GameList() {
    	Game dummyGame1 = new Game("카리나 vs 윈터", "썸네일 1");
    	Game dummyGame2 = new Game("짬뽕 vs 짜장", "썸네일 2");
    	Game dummyGame3 = new Game("집밥 vs 배달", "썸네일 3");
    	
    	gameList.add(dummyGame1);
    	gameList.add(dummyGame2);
    	gameList.add(dummyGame3);
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }

    public void addGame(Game game) {
    	gameList.add(game);
    }
    
    public Game getGame(int index) {
        if (index >= 0 && index < gameList.size()) {
            return gameList.get(index);
        } else {
            return null; 
        }
    }

	public static GameList getInstance() {
		if (instance == null) {  
            instance = new GameList();
        }
        return instance;
	}
}