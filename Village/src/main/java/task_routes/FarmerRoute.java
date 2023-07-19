package task_routes;

import tile.DataTile;

public class FarmerRoute extends Route
{

    public FarmerRoute() {
        startTile = new DataTile(5,9);
        endTile = new DataTile(6,21);
    }


    public DataTile getIntersection(){
        int row = endTile.getRowX();
        int col = startTile.getColX();

        return new DataTile(col, row);

    }


}
