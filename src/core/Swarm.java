package core;
import java.util.ArrayList;
/**
 * Created by (serhii.vasylchenko@gmail.com) on 01.09.2016.
 */
public class Swarm {

    private int swarmSize;
    private ArrayList<Individual> swarmMembers;
    private Room room;
    private long iterationCounter;

    public void initSwarm(Room r, int num) {
        System.out.println("Creating new swarm...");
        this.room = r;
        System.out.println("Room is initialized");
        this.swarmSize = num;
        this.swarmMembers = new ArrayList<>(this.swarmSize);
        for (int i = 0; i < this.swarmSize; i++) {
            this.swarmMembers.add(new Individual());
            this.swarmMembers.get(i).initMember(room, i);
        }
        this.iterationCounter = 0;
    }

    public void doSwarming() {
        this.iterationCounter++;
        System.out.println("Iteration " + this.iterationCounter);
        for (int i = 0; i < this.swarmSize; i++) {
            this.swarmMembers.get(i).doSwarming(Swarm.this);
        }
        this.room.borderManagement(Swarm.this);
    }

    public ArrayList<Individual> getSwarmMembers() {
        return this.swarmMembers;
    }

    public int getSwarmSize() {
        return this.swarmSize;
    }


}
