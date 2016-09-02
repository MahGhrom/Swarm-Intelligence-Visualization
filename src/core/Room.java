package core;

import java.util.Vector;

/**
 * Created by Ghrom on 01.09.2016.
 */
public class Room {

    private Vector<Integer> dimensions;


    public void initRoom(Vector<Integer> v) {
        this.dimensions = new Vector<>();
        this.dimensions = v;
    }

    public Vector<Double> getBorderRepulsion(Vector<Double> position) {
        Vector<Double> repulsion = new Vector<>(this.dimensions.size());
        return repulsion;
    }

    public void borderManagement(Swarm swarm) {

    }

    public Vector<Integer> getDimensions() {
        return this.dimensions;
    }
}
