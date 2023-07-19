package entities;

import graphics.GamePanel;
import handlers.KeyHandler;
import tile.DataTile;

import javax.imageio.ImageIO;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Smurf extends Entity
{
    GamePanel gp;
    KeyHandler keyH;
    private int carryResources;





    public Smurf(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        carryResources = 0;

        setDefaultValues();
        getPlayerImage();
    }

    public int getCarryResources() {
        return carryResources;
    }

    public void setCarryResources(int carryResources) {
        this.carryResources = carryResources;
    }

    public void setDefaultValues()
    {
        x = 60;
        y = 60;
        speed = 1;
        direction = "down";
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




    public void update()
    {

        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {


            if (keyH.upPressed) {
                direction = "up";

            } else if (keyH.downPressed) {
                direction = "down";

            } else if (keyH.rightPressed) {
                direction = "right";

            } else if (keyH.leftPressed) {
                direction = "left";

            }
            // check for collision
            collisionOn = false;

            // if collions false player can move
            if(!collisionOn){
                switch (direction)
                {
                    case "up":
                        y -= speed;
                        break;
                    case "down":
                        y += speed;
                        break;
                    case "left":
                        x -= speed;
                        break;
                    case "right":
                        x += speed;
                        break;
                }
            }

            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }




    }

    public void draw(Graphics2D g2)
    {
//        g2.setColor(Color.white);
//
//        g2.fillRect(x,y,gp.tileSize, gp.tileSize);

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
