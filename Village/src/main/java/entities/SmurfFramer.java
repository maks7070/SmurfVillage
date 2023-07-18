package entities;

import objects.House;

public class SmurfFramer extends Smurf
{
    private int farmingEfficiency;
    private House house;


    public SmurfFramer(int age, int health,int posX, int posY, int farmingEfficiency, House house)
    {
        super(age, health, posX, posY);
        this.farmingEfficiency = farmingEfficiency;
        this.house = house;
    }


    public int getFarmingEfficiency() {
        return farmingEfficiency;
    }

    public void setFarmingEfficiency(int farmingEfficiency) {
        this.farmingEfficiency = farmingEfficiency;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
