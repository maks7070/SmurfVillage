package buildings;

import tile.DataTile;

import java.util.HashMap;

public class MainBuilding extends House{


    int coal;
    int wheat;


    public MainBuilding(DataTile location)
    {
        super(location);
        coal = 1;
        wheat = 1;
    }


    public void updateResource(int element, String type)
    {
        if(type.equals("coal"))
        {
            coal += element;
        }
        else{
            wheat += element;

        }
    }

    public int getCoal() {
        return coal;
    }

    public int getWheat() {
        return wheat;
    }
}
