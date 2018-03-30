package be.cegeka.battle.services.impl;

import be.cegeka.battle.*;
import be.cegeka.battle.services.WarService;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WarServiceImplTest {

    private WarService warService = new WarServiceImpl();


    @Test
    public void fight_theFrontManWhoLosesDies() {
        String otomansArmyName = "otomans";
        Army otomans = new Army(otomansArmyName);
        otomans.enrollSoldier(new Soldier("Daut passa", new Axe()));

        Army dulumans = new Army("dulumans");
        dulumans.enrollSoldier(new Soldier("Duluman", new Axe()));

        Army winner = warService.fight(otomans, dulumans);

        assertThat(dulumans.getSoldiers().isEmpty()).isTrue();
        assertThat(winner.getName()).isEqualTo(otomansArmyName);
    }

    @Test
    public void fight_deadSoldierShouldBeRemovedFromArmy() {
        String otomansArmyName = "otomans";
        Army otomans = new Army(otomansArmyName);
        Soldier dautPassaSoldier = new Soldier("Daut passa", new Sword());
        Soldier hummusSoldier = new Soldier("Hummus", new Spear());

        otomans.enrollSoldier(dautPassaSoldier);
        otomans.enrollSoldier(hummusSoldier);

        String dulumansArmyName = "dulumans";
        Army dulumans = new Army(dulumansArmyName);
        Soldier dulumanSoldier = new Soldier("Duluman", new Spear());
        Soldier valeriuSoldier = new Soldier("Valeriu", new Axe());
        dulumans.enrollSoldier(dulumanSoldier);
        dulumans.enrollSoldier(valeriuSoldier);

        Army winner = warService.fight(otomans, dulumans);

        assertThat(dulumans.getSoldiers().contains(dulumanSoldier)).isFalse();

        assertThat(otomans.getSoldiers().contains(dautPassaSoldier)).isFalse();
        assertThat(otomans.getSoldiers().contains(hummusSoldier)).isFalse();
        assertThat(otomans.getSoldiers().isEmpty()).isTrue();

        assertThat(dulumans.getSoldiers().size()).isEqualTo(1);

        assertThat(winner.getName()).isEqualTo(dulumansArmyName);
    }
}