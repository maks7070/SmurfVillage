package task_routes;

import tile.DataTile;
import tile.Tile;


import java.util.ArrayList;

public class Route
{
    DataTile startingTile;
    DataTile endingTile;
    private ArrayList<DataTile> routeTiles;
    boolean completed;



    public Route(DataTile startingTile, DataTile endingTile) {
        this.startingTile = startingTile;
        this.endingTile = endingTile;
        routeTiles = new ArrayList<>();
        completed = false;
        addTurns();
    }

    public DataTile getStartingTile() {
        return startingTile;
    }

    public void setStartingTile(DataTile startingTile) {
        this.startingTile = startingTile;
    }

    public DataTile getEndingTile() {
        return endingTile;
    }

    public void setEndingTile(DataTile endingTile) {
        this.endingTile = endingTile;
    }

    public ArrayList<DataTile> getRouteTiles() {
        return routeTiles;
    }

    public void setRouteTiles(ArrayList<DataTile> routeTiles) {
        this.routeTiles = routeTiles;
    }

    private void addTurns()
    {

    }
}
