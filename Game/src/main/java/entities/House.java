package entities;

import tile.DataTile;

public class House
{
    public int resourceCounter;
    public int resourceIncrease;
    public String type;
    public DataTile location;


    public House( int resourceIncrease, String type,DataTile location ) {
        this.resourceIncrease = resourceIncrease;
        this.type = type;
        this.location = location;
        resourceCounter = 0;
    }


    public int getResourceCounter() {
        return resourceCounter;
    }

    public void setResourceCounter(int resourceCounter) {
        this.resourceCounter = resourceCounter;
    }

    public int getResourceIncrease() {
        return resourceIncrease;
    }

    public void setResourceIncrease(int resourceIncrease) {
        this.resourceIncrease = resourceIncrease;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DataTile getLocation() {
        return location;
    }

    public void setLocation(DataTile location) {
        this.location = location;
    }
}
