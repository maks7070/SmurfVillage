package entities;

import graphics.GamePanel;
import task_routes.Route;

public class SmurfWarrior extends Smurf{


    public SmurfWarrior(GamePanel gp, Route route) {
        super(gp, route);
        setStartingLocation();
    }



    private void setStartingLocation()
    {
        x = route.startTile.respPointX;
        y = route.startTile.respPointY;
        speed = 1;
        direction = "down";
    }

    String whichWay = "N";
    int distance = 0;





    @Override
    public void update() {
        x += speed;
    }

}
