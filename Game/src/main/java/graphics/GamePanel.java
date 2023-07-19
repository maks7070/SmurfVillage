package graphics;

import entities.House;
import entities.Smurf;
import handlers.KeyHandler;
import handlers.TileMouseListener;
import tile.DataTile;
import tile.TileManager;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

    TileManager tileM = new TileManager(this);
    KeyHandler keyH= new KeyHandler();
    Thread gameThread;
    //TODO

    int resourceIncrease = 2;




    // Create houses

    House farm = new House(resourceIncrease, "wheat", new DataTile(4,9));
    House wood = new House(resourceIncrease, "wood", new DataTile(21,5));





    Smurf player = new Smurf(this, keyH);


    TileMouseListener listener = new TileMouseListener();

    ArrayList<House> houses;


    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.addMouseListener(new MouseListener() {

            private int tileSize = 48;
            private int columns = 30;
            private int rows = 13;

            @Override
            public void mouseClicked(MouseEvent e) {
                int clickX = e.getX();
                int clickY = e.getY();

                int tileX = clickX / tileSize;
                int tileY = clickY / tileSize;

                if(tileX >= 0 && tileX < columns && tileY >= 0 && tileY < rows){
                    for(House h : houses){
                        if(h.location.getRowX() == tileY && h.location.getColX() == tileX)
                        {
                            InformationCard card = new InformationCard(h, player);
                        }

                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        houses = new ArrayList<>();
        houses.add(farm);
        houses.add(wood);



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

            if(timer >= 2000000000)
            {
                //System.out.println("FPS:" + drawCount);
                updateResources();
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update()
    {
        player.update();
    }

    public void updateResources()
    {
        for(House h : houses){
            h.setResourceCounter(h.getResourceCounter() + h.getResourceIncrease());
        }
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        tileM.draw(g2);

        player.draw(g2);


        g2.dispose();
    }


}
