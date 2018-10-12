package com.alicagatay.predictthenumber;

public class User {
    public long userId;
    public String username;
    public String password;
    public int trial;

    public User(long userId, String username, String password, int trial){
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.trial = trial;
    }

}
