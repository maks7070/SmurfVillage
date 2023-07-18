package objects;

public class FarmerHouse extends House
{
    private int gatheredMaterials;

    public FarmerHouse(int posX, int posY)
    {
        super(posX, posY);
        gatheredMaterials = 0;
    }


    public int getGatheredMaterials() {
        return gatheredMaterials;
    }

    public void setGatheredMaterials(int gatheredMaterials) {
        this.gatheredMaterials = gatheredMaterials;
    }
}
