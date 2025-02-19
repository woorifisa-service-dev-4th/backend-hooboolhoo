package dev.hooboolhoo.model;

import java.util.ArrayList;
import java.util.List;

public class GameList {
    private List<Game> gameList = new ArrayList<Game>();
    private static GameList instance;

    public GameList() {
        List<Choice> choices1 = new ArrayList();
        choices1.add(new Choice("카리나"));
        choices1.add(new Choice("윈터"));
    	Game dummyGame1 = new Game("카리나 vs 윈터", "썸네일 1", "user1", choices1);

        List<Choice> choices2 = new ArrayList();
        choices2.add(new Choice("짬뽕"));
        choices2.add(new Choice("짜장"));
        Game dummyGame2 = new Game("짬뽕 vs 짜장", "썸네일 2","user2",choices2);

        List<Choice> choices3 = new ArrayList();
        choices3.add(new Choice("집밥"));
        choices3.add(new Choice("배달"));
        Game dummyGame3 = new Game("집밥 vs 배달", "썸네일 3","user3",choices3);
        
        List<Choice> choices4 = new ArrayList();
        choices4.add(new Choice("깻잎"));
        choices4.add(new Choice("상추"));
        Game dummyGame4 = new Game("집밥 vs 배달", "썸네일 3","user3",choices4);
    	
    	gameList.add(dummyGame1);
    	gameList.add(dummyGame2);
    	gameList.add(dummyGame3);
    	gameList.add(dummyGame4);
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