package be.cegeka.battle.services;

import be.cegeka.battle.Army;

public interface WarService {

    Army fight(Army attacker,Army defender);
}
