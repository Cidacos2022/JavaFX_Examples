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
public class BettingResult {

    /**
     * @return the maxEarnBet
     */
    public int getMaxEarnBet() {
        return maxEarnBet;
    }

    /**
     * @param maxEarnBet the maxEarnBet to set
     */
    private void setMaxEarnBet(int maxEarnBet) {
        this.maxEarnBet = Math.max(this.maxEarnBet, maxEarnBet);
    }

    /**
     * @return the maxLostBet
     */
    public int getMaxLostBet() {
        return maxLostBet;
    }

    /**
     * @param maxLostBet the maxLostBet to set
     */
    private void setMaxLostBet(int maxLostBet) {
        this.maxLostBet = Math.max(this.maxLostBet, maxLostBet);
    }

    /**
     * @return the sumLostBet
     */
    public int getSumLostBet() {
        return sumLostBet;
    }

    /**
     * @param sumLostBet the sumLostBet to set
     */
    private void setSumLostBet(int sumLostBet) {
        this.sumLostBet += sumLostBet;
    }

    /**
     * @return the sumEarnBet
     */
    public int getSumEarnBet() {
        return sumEarnBet;
    }

    /**
     * @param sumEarnBet the sumEarnBet to set
     */
    private void setSumEarnBet(int sumEarnBet) {
        this.sumEarnBet += sumEarnBet;
    }

    public void recordBet(int number) {
        if (number > 0) {
            setSumEarnBet(number);
            setMaxEarnBet(number);
        } else {
            setSumLostBet(-number);
            setMaxLostBet(-number);
        }
    }

    private int maxEarnBet;
    private int maxLostBet;
    private int sumLostBet;
    private int sumEarnBet;

}
