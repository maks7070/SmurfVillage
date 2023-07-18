package entities;

import objects.House;

public class Smurfette extends Smurf
{
    private House house;



    public Smurfette(int age, int health, int posX, int posY, House house)
    {
        super(age, health, posX, posY);
        this.house = house;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
