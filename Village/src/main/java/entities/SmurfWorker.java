package entities;

import objects.House;


public class SmurfWorker extends Smurf
{
    private House house;
    private int gatheringEfficiency;



    public SmurfWorker(int age, int health, int posX, int posY,int gatheringEfficiency,  House house)
    {
        super(age, health,posX,posY);
        this.house = house;
        this.gatheringEfficiency = gatheringEfficiency;
    }


    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public int getGatheringEfficiency() {
        return gatheringEfficiency;
    }

    public void setGatheringEfficiency(int gatheringEfficiency) {
        this.gatheringEfficiency = gatheringEfficiency;
    }
}
