package graphics;

import buildings.House;
import buildings.MainBuilding;
import tile.DataTile;

import java.util.ArrayList;

public class Village
{
    ArrayList<House> houses;
    MainBuilding hq;

    public Village()
    {
        houses = new ArrayList<>();
        addHouses();
        hq = new MainBuilding(new DataTile(21,5));
        houses.add(hq);
    }


    private void addHouses()
    {
        House h = new House(new DataTile(5,9), "Farm", "wheat");
        House h1 = new House(new DataTile(14,9), "Mine", "coal");
        houses.add(h);
        houses.add(h1);
    }


    public ArrayList<House> getHouses() {
        return houses;
    }

    public MainBuilding getHq() {
        return hq;
    }
}
