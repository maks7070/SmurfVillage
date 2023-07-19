package entities;

import graphics.GamePanel;
import task_routes.Route;
import tile.DataTile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Smurf extends Entity
{
    GamePanel gp;

    Route route;




    public Smurf(GamePanel gp, Route route){
        this.gp = gp;
        this.route = route;
        getPlayerImage();
    }



    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/players/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/players/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/players/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/players/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/players/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/players/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/players/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/players/boy_right_2.png"));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }




    public abstract void update();




    public void draw(Graphics2D g2)
    {
        BufferedImage image = null;

        switch (direction){
            case "up":
                if(spriteNum == 1)
                {
                    image = up1;
                }
                if(spriteNum == 2)
                {
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;
                }
                break;
            case "right":
                if(spriteNum == 1)
                {
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
                break;
            case "left":
                if(spriteNum == 1)
                {
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }
                break;
        }

        g2.drawImage(image, x, y , gp.tileSize/2, gp.tileSize/2, null);
    }
}
