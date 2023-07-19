package graphics;

import buildings.House;
import entities.Smurf;
import entities.SmurfDelivery;
import entities.SmurfFarmer;
import handlers.TileMouseListener;
import task_routes.FarmerRoute;
import task_routes.WariorRoute;
import task_routes.WoodRoute;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable
{
    public final int originalTileSize = 16; //each tile is 16x16
    public final int scale = 3;

    public final int tileSize = originalTileSize * scale; // 48x48 size for each tile
    public final int maxScreenCol = 30; // 16 tiles horizontaly
    public final int maxScreenRow = 13; // 12 tiles verticaly

    public final int screenWidth = tileSize * maxScreenCol; // 768px
    public final int screenHeight = tileSize * maxScreenRow; // 567px

    int FPS = 60;
    Village village = new Village();
    TileManager tileM = new TileManager(this);
    Thread gameThread;
    //TODO

    ArrayList<Smurf> smurfs;




    SmurfDelivery sf = new SmurfDelivery(this, new FarmerRoute(), "wheat", village.getHouses().get(0), village.getHq());
    SmurfDelivery sd1 = new SmurfDelivery(this, new WoodRoute(), "coal", village.getHouses().get(0), village.getHq());
    SmurfFarmer sw = new SmurfFarmer(this, new WariorRoute(), village.getHouses().get(0));





    TileMouseListener listener = new TileMouseListener();





    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addMouseListener(listener);

        smurfs = new ArrayList<>();
        smurfs.add(sf);
        smurfs.add(sw);
        smurfs.add(sd1);



    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        while (gameThread != null)
        {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1)
            {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000)
            {
                //System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update()
    {
        //sf.update();

        for(Smurf s : smurfs){
            s.update();
        }

        for(House h : village.houses){
            System.out.println(h.getResources());
        }
        System.out.println("Coal: " + village.getHq().getCoal());
        System.out.println("Wheat: " + village.getHq().getWheat());
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        tileM.draw(g2);

        for(Smurf s: smurfs)
        {
            s.draw(g2);
        }


        g2.dispose();
    }


}
