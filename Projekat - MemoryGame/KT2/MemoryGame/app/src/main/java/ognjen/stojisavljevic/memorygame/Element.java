package ognjen.stojisavljevic.memorygame;

import java.util.ArrayList;
import java.util.Collections;

public class Element{
    private String username;
    private String email;
    private String best;
    private String worst;
    private Integer bestResult;
    private Integer worstResult;
    private ArrayList<Integer> results;

    public Element(String username, String email, Integer bestResult, Integer worstResult) {
        this.username = username;
        this.email = email;
        this.bestResult = bestResult;
        this.worstResult = worstResult;
        this.best = "Best";
        this.worst = "Worst";
        this.results = new ArrayList<>();
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

    public Integer getBestResult() {
        return bestResult;
    }

    public void setBestResult(Integer bestResult) {
        this.bestResult = bestResult;
    }

    public Integer getWorstResult() {
        return worstResult;
    }

    public void setWorstResult(Integer worstResult) {
        this.worstResult = worstResult;
    }

    public ArrayList<Integer> getResults() {
        return results;
    }

    public void setResults(ArrayList<Integer> results) {
        this.results = results;
    }
}
