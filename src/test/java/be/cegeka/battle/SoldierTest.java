package be.cegeka.battle;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SoldierTest {

    @Test
    public void construction_ASoldierMustHaveAName() {
        Soldier soldier = new Soldier("name");

        assertThat(soldier.getName()).isEqualTo("name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeNull() {
        new Soldier(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeEmpty() {
        new Soldier("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeBlank() {
        new Soldier("   ");
    }

    @Test
    public void fight_TheAttackerSoldierWithStrongerWeaponWins() {
        Soldier attacker = new Soldier("Jim", new Sword());
        Soldier defender = new Soldier("Jimmy");

        FightResult fightResult = attacker.fight(defender);
        assertThat(fightResult.getWinner()).isEqualTo(attacker);
    }

    @Test
    public void fight_ifWeaponHaveSameDamageAttackerWins() {
        Soldier attacker = new Soldier("Jim", new Sword());
        Soldier defender = new Soldier("Jimmy", new Sword());

        FightResult fightResult = attacker.fight(defender);
        assertThat(fightResult.getWinner()).isEqualTo(attacker);
    }

    @Test
    public void fight_TheDefenderSoldierWithStrongerWeaponWins() {
        Soldier attacker = new Soldier("Jim");
        Soldier defender = new Soldier("Jimmy", new Sword());

        FightResult fightResult = attacker.fight(defender);
        assertThat(fightResult.getWinner()).isEqualTo(defender);
    }
}