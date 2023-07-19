package entities;

import buildings.House;
import buildings.MainBuilding;
import graphics.GamePanel;
import task_routes.Route;

public class SmurfFarmer extends Smurf{

    House house;
    boolean receiving;
    boolean back;
    MainBuilding mainBuilding;


    public SmurfFarmer(GamePanel gp, Route route, House house) {
        super(gp, route);
        setStartingLocation();
        receiving = false;
        this.house = house;


    }



    private void setStartingLocation()
    {
        x = route.startTile.respPointX;
        y = route.startTile.respPointY;
        speed = 1;
        direction = "down";
    }





    String whichWay = "S";
    int counter = 0;


    @Override
    public void update() {

            if(whichWay.equals("S")){
                direction = "down";
                y += speed;

                if(y <= 480 && y >= 432)
                {
                    whichWay = "N";
                    counter++;
                }

            }if(whichWay.equals("N")){
                direction = "up";
                y -= speed;
                if(y >= 336 && y <= 384)
                {
                    direction = "up";
                    spriteNum = 1;
                    whichWay = "S";
                    counter++;
                }
            }

            if(counter > 10)
            {
                //TODO: update house details
                house.setResources(house.getResources() + 5);
            }
    }


}
