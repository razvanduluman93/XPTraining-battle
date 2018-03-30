package be.cegeka.battle;

public class FightResult {
    private Soldier winner;
    private Soldier loser;

    public FightResult(Soldier winner, Soldier loser) {
        this.winner = winner;
        this.loser = loser;
    }

    public Soldier getWinner() {
        return winner;
    }

    public void setWinner(Soldier winner) {
        this.winner = winner;
    }

    public Soldier getLoser() {
        return loser;
    }

    public void setLoser(Soldier loser) {
        this.loser = loser;
    }
}
