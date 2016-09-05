package core;

import java.lang.Math;
import java.util.Vector;

/**
 * Main class for individuals in the swarm.
 *
 * Created by Ghrom on 01.09.2016.
 */
public class Individual {

    private int ID = 0;
    private Room room;
    private int dimensionsNum = 0;
    private Vector<Double> position;
    private Vector<Double> velocity;
    private double inertiaValue = 0.3;
    private double startingVelocity = 3;
    private double direction = 0;

    /**
     * Initialize new individual
     *
     * @param room Room for moving
     * @param id Identification number of the new individual
     */
    public void initMember(Room room, int id) {
        this.room = room;
        this.ID = id;
        this.dimensionsNum = room.getDimensions().size();
        this.position = new Vector<>();
        this.velocity = new Vector<>();
        for (int i = 0; i < room.getDimensions().size(); i++) {
            this.position.add(i, Math.random()*(room.getDimensions().get(i) / 10));
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

    /**
     * Calculate new positions according to others members of the swarm.
     * Currently uses "Seek a comfortable distance" as attraction and repulsion function
     * TODO: Implement other functions
     *
     * @param swarm Swarm of the individuals (to get other members)
     */
    public void doSwarming(Swarm swarm) {
        // Seek a comfortable distance. Attraction/repulsion function:
        // f = -k*(distance(thisMember - otherMember) - comfortableDistance)
        // SwarmFunction - average sum of f() with every other individual in the swarm
        double f;
        Vector<Double> swarmFunction = new Vector<>();
        for (int j = 0; j < this.dimensionsNum; j++) {
            swarmFunction.add((double) 0);
            swarmFunction.add((double) 0);
        }
        double k = 0.1;
        double currentDistance;
        double comfortableDistance = 20;

        for (int i = 0; i < swarm.getSwarmSize(); i++) {
            if (ID != i) {
                currentDistance = Distance.euclidean(swarm.getSwarmMembers().get(i).getPosition(), this.position);
                for (int j = 0; j < this.dimensionsNum; j++) {
                    f = -k * (currentDistance - comfortableDistance) * (this.position.get(j) - swarm.getSwarmMembers().get(i).getPosition().get(j));
                    swarmFunction.set(j, swarmFunction.get(j) + f);
                }
            }
        }
        for (int j = 0; j < this.dimensionsNum; j++) {
            swarmFunction.set(j, swarmFunction.get(j) / (swarm.getSwarmSize() - 1));
        }

        // Motion equations:
        // pos(i+1) = pos(i) + vel(i+1)
        // vel(i+1) = inertiaValue * vel(i) + swarmFunction + borderRepulsion
        for (int i = 0; i < this.dimensionsNum; i++) {
            this.velocity.set(i, this.inertiaValue * this.velocity.get(i) + swarmFunction.get(i) + this.room.getBorderRepulsion(this.position).get(i));
            this.position.set(i, this.position.get(i) + this.velocity.get(i));
        }
    }
}
