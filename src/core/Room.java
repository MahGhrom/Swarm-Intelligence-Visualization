package core;

import java.util.Vector;

/**
 * Created by Ghrom on 01.09.2016.
 */
public class Room {

    private int width;
    private int height;

    public void initRoom(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public Vector<Double> getBorderRepulsion() {

    }

    public void borderManagement(Swarm swarm) {

    }

    public int getWidth() {
       return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
