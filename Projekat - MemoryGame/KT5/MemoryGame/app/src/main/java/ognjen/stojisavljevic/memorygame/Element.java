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

    public void addRez(int i){
        results.add(i);
        Collections.sort(results, Collections.reverseOrder());
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBest() {
        return best;
    }

    public void setBest(String best) {
        this.best = best;
    }

    public String getWorst() {
        return worst;
    }

    public void setWorst(String worst) {
        this.worst = worst;
    }

    public String getBestResult() {
        return bestResult;
    }

    public void setBestResult(String bestResult) {
        this.bestResult = bestResult;
    }

    public String getWorstResult() {
        return worstResult;
    }

    public void setWorstResult(String worstResult) {
        this.worstResult = worstResult;
    }

    public ArrayList<Integer> getResults() {
        return results;
    }

    public void setResults(ArrayList<Integer> results) {
        this.results = results;
    }

    public int getGameID() {
        return gameID;
    }

    public String getPoints() {
        return points;
    }
}
