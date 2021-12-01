/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.game;

/**
 *
 * @author rafael
 */
public class CurrentGame {

    private boolean beingPlayed;
    private boolean secondTurn;
    private boolean finished;

    private static CurrentGame instance;

    private CurrentGame() {
    }

    public static CurrentGame getInstance() {
        if (instance == null) {
            instance = new CurrentGame();

        }
        return instance;
    }

    /**
     * @return the isBeingPlayed
     */
    public boolean isBeingPlayed() {
        return beingPlayed;
    }

    /**
     * @return the isSecondTurn
     */
    public boolean isSecondTurn() {
        return secondTurn;
    }

    /**
     * @return the finished
     */
    public boolean isFinished() {
        return finished;
    }

    public void finish() {
        finished = true;
        beingPlayed = false;
        secondTurn = false;
    }

    public void restart() {
        finished = false;
        beingPlayed = false;
        secondTurn = false;
    }

    public void start() {
        beingPlayed = true;
        secondTurn = true;
    }

}
