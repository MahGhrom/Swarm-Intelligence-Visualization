package core;

import java.lang.Math;
import java.util.Vector;

/**
 * Created by Ghrom on 01.09.2016.
 */
public class Individual {

    private int ID = 0;
    private int dimensionsNum = 0;
    private Vector<Double> position;
    private Vector<Double> velocity;
    private double inertiaValue = 0.3;
    private double startingVelocity = 3;
    private double direction = 0;

    public void initMember(Room room, int id) {
        this.ID = id;
        this.dimensionsNum = room.getDimensions().size();
        this.position = new Vector<>();
        this.velocity = new Vector<>();
        for (int i = 0; i < room.getDimensions().size(); i++) {
            this.position.add(i, Math.random()*room.getDimensions().get(i));
            this.velocity.add(i,(Math.random()*this.startingVelocity*2 - this.startingVelocity));
        }
        System.out.println(this.ID + ": " + this.position.get(0) + " - " + this.position.get(1));
    }

    public Vector<Double> getPosition() {
        return this.position;
    }

    public Vector<Double> getVelocity() {
        return this.velocity;
    }

    public double getDirection() {
        return this.direction;
    }

    public void doSwarming(Swarm swarm) {
        Vector<Double> function = new Vector<>();
        Vector<Double> functionSum = new Vector<>();
        for (int j = 0; j < this.dimensionsNum; j++) {
            functionSum.add((double)0);
        }
        double k = 0.1;
        double currentDistance;
        double comfortableDistance = 20;

        for (int i = 0; i < swarm.getSwarmSize(); i++) {
            currentDistance = Distance.euclidean(swarm.getSwarmMembers().get(i).getPosition(), this.position);
            for (int j = 0; j < this.dimensionsNum; j++) {
                function.add(j, (-k * (currentDistance - comfortableDistance) * (this.position.get(j) - swarm.getSwarmMembers().get(i).getPosition().get(j))));
                functionSum.set(j, functionSum.get(j) + function.get(j));
            }
        }
        for (int i = 0; i < this.dimensionsNum; i++) {
            this.velocity.set(i, this.velocity.get(i) * this.inertiaValue + functionSum.get(i));
            this.position.set(i, this.position.get(i) + this.velocity.get(i));
        }
    }


}
