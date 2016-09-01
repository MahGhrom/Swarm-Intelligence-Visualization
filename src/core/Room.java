package core;

import java.util.Vector;

/**
 * Created by Ghrom on 01.09.2016.
 */
public class Room {

    private Vector<Integer> dimentions;


    public void initRoom(Vector<Integer> v) {
        this.dimentions = new Vector<>();
        this.dimentions = v;
    }

    public Vector<Double> getBorderRepulsion() {

    }

    public void borderManagement(Swarm swarm) {

    }

    public Vector<Integer> getDimentions() {
        return this.dimentions;
    }
}
