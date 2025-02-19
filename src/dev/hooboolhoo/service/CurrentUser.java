package dev.hooboolhoo.service;

import dev.hooboolhoo.model.User;

public class CurrentUser {
    private static CurrentUser currentUser;
    private User user;

    public CurrentUser() {}

    public static CurrentUser getInstance() {
        if (currentUser == null) {
            currentUser = new CurrentUser();
        }

        return currentUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
