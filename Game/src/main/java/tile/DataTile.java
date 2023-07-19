package tile;

import entities.House;

public class DataTile
{
    private int colX;
    private int rowX;

    public int coordX;
    public int coordY;




    public DataTile(int colX, int rowX)
    {
        this.colX = colX;
        this.rowX = rowX;

    }

    public int getColX() {
        return colX;
    }

    public int getRowX() {
        return rowX;
    }
}
