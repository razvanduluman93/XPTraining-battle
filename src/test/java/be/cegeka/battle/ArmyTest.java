package be.cegeka.battle;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArmyTest {


    @Test
    public void Army_newArmyShouldContainEmptyListOfSoldiers() {
        Army army = new Army("dulumans");

        assertThat(army.getSoldiers().isEmpty()).isTrue();
    }

    @Test
    public void addSoldier_armyShouldContainTheSoldier() {
        Army otomans = new Army("dulumans");
        Soldier otoman = new Soldier("Pașa Hassan");
        otomans.enrollSoldier(otoman);

        assertThat(otomans.getSoldiers().contains(otoman)).isTrue();
    }

    @Test
    public void addSoldier_firstEnlistedIsFrontMan() {
        Army otomans = new Army("dulumans");

        Soldier first = new Soldier("FrontMan");
        Soldier secondMan = new Soldier("Coward");

        otomans.enrollSoldier(first);
        otomans.enrollSoldier(secondMan);

        assertThat(otomans.getFrontMan().equals(first)).isTrue();
    }
}