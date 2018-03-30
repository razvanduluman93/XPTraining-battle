package be.cegeka.battle.services.impl;

import be.cegeka.battle.Army;
import be.cegeka.battle.FightResult;
import be.cegeka.battle.Soldier;
import be.cegeka.battle.services.WarService;

public class WarServiceImpl implements WarService {


    @Override
    public Army fight(Army attacker, Army defender) {
        while (isWar(attacker, defender)) {
            Soldier attackerFrontMan = attacker.getFrontMan();
            Soldier defenderFrontMan = defender.getFrontMan();

            FightResult result = attackerFrontMan.fight(defenderFrontMan);

            if (result.getLoser().equals(defenderFrontMan)) {
                defender.killFrontSoldier();
            } else {
                attacker.killFrontSoldier();
            }
        }

        return attacker.getSoldiers().isEmpty() ? defender : attacker;
    }

    private boolean isWar(Army attacker, Army defender) {
        return !attacker.getSoldiers().isEmpty() && !defender.getSoldiers().isEmpty();
    }
}
