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
        for (int i = 0; i < this.dimensions.size(); i++) {
            repulsion.add((double)0);
            // TODO: Implement repulsion from the borders of the room
        }
        return repulsion;
    }

    public void borderManagement(Swarm swarm) {
        // TODO: Manage the cases, when individual accidentally goes out the borders of the room
    }

    public Vector<Integer> getDimensions() {
        return this.dimensions;
    }
}
