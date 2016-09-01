package core;
import java.util.ArrayList;
/**
 * Created by Ghrom on 01.09.2016.
 */
public class Swarm {

    private int swarmSize;
    private ArrayList<Individual> swarmMembers;
    private ArrayList<int, int> distances;
    private Room room;

    public void initSwarm(int num) {
        this.swarmSize = num;
        this.swarmMembers = new ArrayList<>(this.swarmSize);
        for (int i = 0; i < this.swarmSize; i++) {
            this.swarmMembers.get(i).initMember(room, i);
        }
    }

    public void doSwarming() {
        for (int i = 0; i < this.swarmSize; i++) {
            this.swarmMembers.get(i).doSwarming(Swarm.this);
        }
    }

    public ArrayList<Individual> getSwarmMembers() {
        return this.swarmMembers;
    }

    public int getSwarmSize() {
        return this.swarmSize;
    }


}
