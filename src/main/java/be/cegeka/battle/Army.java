package be.cegeka.battle;

import java.util.LinkedList;
import java.util.Queue;

public class Army {
    private Queue<Soldier> soldiers = new LinkedList<>();

    public Queue<Soldier> getSoldiers() {
        return soldiers;
    }

    public void addSoldier(Soldier soldier) {
        soldiers.add(soldier);
    }

    public Soldier getFrontMan() {
        return soldiers.peek();
    }
}
