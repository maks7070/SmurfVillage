package tile;

import graphics.GamePanel;


import javax.imageio.ImageIO;
import javax.xml.crypto.Data;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager
{
    private GamePanel gp;
    public Tile []tile;
    public int[][] mapTileNum;

    public DataTile [][] dataMap;

    public TileManager(GamePanel gp)
    {
        this.gp = gp;
        tile = new Tile[10];

        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        dataMap = new DataTile[gp.maxScreenCol][gp.maxScreenRow];

        getTileImage();
        loadMap("/maps/map1.txt");
    }

    public void getTileImage()
    {
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/hut1.png"));


        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void loadMap(String path)
    {
        try{
            InputStream is = getClass().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxScreenCol && row < gp.maxScreenRow)
            {
                String line = br.readLine();

                while(col < gp.maxScreenCol){
                    String []numbers = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    dataMap[col][row] = new DataTile(col, row);
                    col++;

                }
                if(col == gp.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            br.close();




        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void draw(Graphics2D g2)
    {
        //g2.drawImage(tile[0].image, 0,0, gp.tileSize, gp.tileSize,null);

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < gp.maxScreenCol && row < gp.maxScreenRow)
        {
            int tileNum = mapTileNum[col][row];
            dataMap[col][row].coordX = x;
            dataMap[col][row].coordY = y;
            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if(col == gp.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }
}
