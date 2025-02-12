package dev.hooboolhoo.model;

public class Choice {
    private String name;
    private int count;

    public Choice() {

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

    public void setCount(int count) {
        this.count = count;
    }

    public void setCount() {
        count++;
    }
}
