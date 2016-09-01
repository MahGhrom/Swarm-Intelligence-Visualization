package core;

import java.lang.Math;
import java.util.Vector;

/**
 * Created by Ghrom on 01.09.2016.
 */
public class Individual {

    private int ID = 0;
    private int dimentionsNum = 0;
    private Vector<Double> position;
    private Vector<Double> velocity;
    private double inertiaValue = 0.3;
    private double startingVelocity = 3;
    private double direction = 0;

    public void initMember(Room room, int id) {
        this.ID = id;
        this.dimentionsNum = room.getDimentions().size();
        this.position = new Vector<>();
        this.velocity = new Vector<>();
        for (int i = 0; i < room.getDimentions().size(); i++) {
            this.position.add(i, Math.random()*room.getDimentions().get(i));
            this.velocity.add(i,(Math.random()*this.startingVelocity*2 - this.startingVelocity));
        }
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
        for (int j = 0; j < this.dimentionsNum; j++) {
            functionSum.add((double)0);
        }
        double k = 0.1;
        double currentDistance;
        double comfortableDistance = 20;

        for (int i = 0; i < swarm.getSwarmSize(); i++) {
            currentDistance = Distance.euclidean(swarm.getSwarmMembers().get(i).getPosition(), this.position);
            for (int j = 0; j < this.dimentionsNum; j++) {
                function.add(j, (-k * (currentDistance - comfortableDistance) * (this.position.get(j) - swarm.getSwarmMembers().get(i).getPosition().get(j))));
                functionSum.set(j, functionSum.get(j) + function.get(j));
            }
        }
        for (int i = 0; i < this.dimentionsNum; i++) {
            this.velocity.set(i, this.velocity.get(i) * this.inertiaValue + functionSum.get(i));
            this.position.set(i, this.position.get(i) + this.velocity.get(i));
        }
    }


}
