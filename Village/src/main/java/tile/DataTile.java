package tile;

public class DataTile
{
    private int colX;
    private int rowX;

    public int coordX;
    public int coordY;

    public int respPointX;
    public int respPointY;



    public DataTile(int colX, int rowX)
    {
        this.colX = colX;
        this.rowX = rowX;

        coordX = colX * 48;
        coordY = rowX * 48;

        respPointX = coordX + 12;
        respPointY = coordY + 12;

    }

    public int getColX() {
        return colX;
    }

    public int getRowX() {
        return rowX;
    }
}
