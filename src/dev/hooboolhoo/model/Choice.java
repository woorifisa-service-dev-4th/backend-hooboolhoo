package dev.hooboolhoo.model;

public class Choice {
    private String name;
    private int count;

    // count 초기값 0
    public Choice(String name) {
        this(name, 0);
    }
    
    public Choice(String name, int count) {
        this.name = name;
        this.count = count;
    }
    
    public String getName() {
        return name;
    }
    
    public int getCount() {
        return count;
    }
    
    // 선택하면 count를 1씩 증가
    public void incrementCount() {
        this.count++;
    }
}
