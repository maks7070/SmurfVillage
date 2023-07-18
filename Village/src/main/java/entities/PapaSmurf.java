package entities;

/**
 * PapaSumrf - the leader of the village if alive then the resource boost is applied
 */
public class PapaSmurf extends Smurf
{
    private int resourceBoost;


    public PapaSmurf(int age, int health, int posX, int posY){
        super(age, health, posX, posY);
        resourceBoost = 5;
    }


    public int getResourceBoost() {
        return resourceBoost;
    }

    public void setResourceBoost(int resourceBoost) {
        this.resourceBoost = resourceBoost;
    }
}
