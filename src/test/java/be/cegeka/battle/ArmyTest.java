package be.cegeka.battle;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArmyTest {


    @Test
    public void Army_newArmyShouldContainEmptyListOfSoldiers() {
        Army army = new Army();

        assertThat(army.getSoldiers().isEmpty()).isTrue();
    }

    @Test
    public void addSoldier_armyShouldContainTheSoldier() {
        Army otomans = new Army();
        Soldier otoman = new Soldier("Pașa Hassan");
        otomans.addSoldier(otoman);

        assertThat(otomans.getSoldiers().contains(otoman)).isTrue();
    }

    @Test
    public void addSoldier_firstEnlistedIsFrontMan() {
        Army otomans = new Army();

        Soldier first = new Soldier("FrontMan");
        Soldier secondMan = new Soldier("Coward");

        otomans.addSoldier(first);
        otomans.addSoldier(secondMan);

        assertThat(otomans.getFrontMan().equals(first)).isTrue();
    }
}