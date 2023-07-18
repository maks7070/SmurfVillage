package entities;

import objects.House;
import objects.Weapon;

/**
 * The warrior of the village, defends againts threats coming into the village, uses weapons
 * from the smith
 */
public class SmurfWarrrior extends Smurf
{
    private Weapon weapon;
    private House house;


    public SmurfWarrrior(int age, int health,int posX, int posY, House house)
    {
        super(age, health, posX, posY);
        this.house = house;
        weapon = new Weapon();
    }


    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
