package ognjen.stojisavljevic.memorygame;

import java.util.ArrayList;
import java.util.Collections;

public class Element{
    private String username;
    private int gameID;
    private String email;
    private String points;

    private String best;
    private String worst;
    private String bestResult;
    private String worstResult;
    private ArrayList<Integer> results;

    public Element(String username, String email, String bestResult, String worstResult) {
        this.username = username;
        this.email = email;
        this.bestResult = bestResult;
        this.worstResult = worstResult;
        this.best = "Best";
        this.worst = "Worst";
        this.results = new ArrayList<>();
    }

    public Element(int GameID, String Username, String Gmail, String Points){
        this.gameID = GameID;
        this.username = Username;
        this.email = Gmail;
        this.points = Points;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public String getBest() {
        return best;
    }

    public String getWorst() {
        return worst;
    }

    public String getBestResult() {
        return bestResult;
    }

    public String getWorstResult() {
        return worstResult;
    }

    public int getGameID() {
        return gameID;
    }

    public String getPoints() {
        return points;
    }
}
