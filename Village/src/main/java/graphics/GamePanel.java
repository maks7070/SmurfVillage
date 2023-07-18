package graphics;

import entities.Smurf;
import handlers.KeyHandler;
import handlers.TileMouseListener;
import task_routes.Route;
import tile.DataTile;
import tile.TileManager;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;

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

    TileManager tileM = new TileManager(this);
    KeyHandler keyH= new KeyHandler();
    Thread gameThread;
    //TODO
    DataTile t1 = new DataTile(1,1);
    DataTile t2 = new DataTile(1,2);
    Route r = new Route(t1,t2);
    Smurf player = new Smurf(this, keyH,r);


    TileMouseListener listener = new TileMouseListener();


    //entities.Player default position:

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;


    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.addMouseListener(listener);

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
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update()
    {
        player.update();
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        tileM.draw(g2);

        player.draw(g2);


        g2.dispose();
    }


}
