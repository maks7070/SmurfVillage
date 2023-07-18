package objects;

public class Weapon
{
    private String name;
    private int damage;


    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public Weapon()
    {
        name = "Smurf spear";
        damage = 10;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void upgradeWeapon(){
        if(getDamage() < 100)
        {
            setDamage(getDamage() + 10);
        }
    }
}
