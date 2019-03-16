package logic;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

public class Stat {

    private ArrayList<Result> results;
    private static HashMap<HttpSession, Stat> sessions = new HashMap<HttpSession, Stat>();
    private float humanWins; //in percents
    private float robotWins; //in percents

    private Stat() {
        this.results = new ArrayList<Result>();
        this.humanWins = 0;
        this.robotWins = 0;
    }

    public static Stat getInstance(HttpSession httpSession) {
        Stat instance;
        if (!sessions.containsKey(httpSession)) {
            instance = new Stat();
            sessions.put(httpSession, instance);
        } else {
            instance = sessions.get(httpSession);
        }
        return instance;
    }

    public void addResult(Result result) {
        //Stat(session);
        results.add(result);
    }

    public ArrayList<Result> getList() {
        return results;
    }

    public void countStat() {
        float playedGames = 0;
        float humanScore = 0;
        float robotScore = 0;
        for (Result current : results) {
            if (current.getWinner().equals("Human")) { //hardcoded
                humanScore++;

            } else if (current.getWinner().equals("Robot")) {
                robotScore++;
            }
            playedGames++;
        }
        humanWins = (humanScore / playedGames) * 100;
        robotWins = (robotScore / playedGames) * 100;
    }

    public float getHumanWins() {
        return humanWins;
    }

    public float getRobotWins() {
        return robotWins;
    }

}
