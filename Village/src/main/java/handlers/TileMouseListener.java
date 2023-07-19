package handlers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TileMouseListener implements MouseListener
{
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
            System.out.println("Location");
            System.out.println(tileX);
            System.out.println(tileY);
            System.out.println("__________________________");
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
}
