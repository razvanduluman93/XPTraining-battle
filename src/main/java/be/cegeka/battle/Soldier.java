package be.cegeka.battle;

import org.apache.commons.lang3.Validate;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class Soldier {

    private final String name;
    private Weapon weapon = new BearFist();

    public Soldier(String name) {
        Validate.isTrue(isNotBlank(name));
        this.name = name;




    }

    public Soldier(String name, Weapon weapon) {
        this(name);
        this.weapon = weapon;
    }

    String getName() {
        return this.name;
    }

    public int getWeaponDamage() {
        return weapon.getDamage();
    }

    public FightResult fight(Soldier defender) {
        if (this.getWeaponDamage() >= defender.getWeaponDamage()) {
            return new FightResult(this, defender);
        }

        return new FightResult(defender, this);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Soldier && ((Soldier) obj).getName().equals(this.getName());
    }
}
