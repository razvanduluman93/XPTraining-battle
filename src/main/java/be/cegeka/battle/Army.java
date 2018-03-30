package be.cegeka.battle;

import java.util.LinkedList;
import java.util.Queue;

public class Army {

    private String name;

    public Army(String name) {
        this.name = name;
    }

    private Queue<Soldier> soldiers = new LinkedList<>();

    public Queue<Soldier> getSoldiers() {
        return soldiers;
    }

    public void enrollSoldier(Soldier soldier) {
        soldiers.add(soldier);
    }

    public Soldier getFrontMan() {
        return soldiers.peek();
    }

    public String getName() {
        return name;
    }

    public void killFrontSoldier() {
        Soldier deadSoldier = soldiers.poll();

        System.out.println("Soldier with name " + deadSoldier.getName() + " died");
    }
}
