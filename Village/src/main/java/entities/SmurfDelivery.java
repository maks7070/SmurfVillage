package entities;

import graphics.GamePanel;
import task_routes.FarmerRoute;
import task_routes.Route;
import tile.DataTile;

public class SmurfFarmer extends Smurf
{

    private int resources;
    private boolean toMagazine;


    int intersectionTopY;

    public SmurfFarmer(GamePanel gp, FarmerRoute route) {
        super(gp, route);
        resources = 0;
        toMagazine = true;
        setStartingLocation();





    }

    private void setStartingLocation()
    {
        x = route.startTile.respPointX;
        y = route.startTile.respPointY;
        speed = 5;
        direction = "down";
    }
    String whichWay = "N";
    int distance = 0;

    @Override
    public void update() {
        if(toMagazine)
        {
            if(whichWay.equals("N")){
                direction = "up";
                y -= speed;

                if(y <= 288 && y >= 240)
                {
                    whichWay = "E";
                }

            }if(whichWay.equals("E")){
                direction = "right";
                x += speed;
                if(x >= 1008 && x <= 1056)
                {
                    toMagazine = false;
                    direction = "up";
                    spriteNum = 1;
                    whichWay = "W";
                }
            }

        }
        else{
            if(whichWay.equals("W"))
            {
                direction = "left";
                x -= speed;

                if(x <= 240 && y >= 192)
                {
                    whichWay = "S";
                }
            }if(whichWay.equals("S"))
            {
                direction = "down";
                y += speed;

                if(y >= 432 && y <= 480)
                {
                    toMagazine = true;
                    direction = "left";
                    spriteNum = 1;
                    whichWay = "N";
                }
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
