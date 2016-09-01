package core;
import java.util.ArrayList;
/**
 * Created by Ghrom on 01.09.2016.
 */
public class Swarm {

    private int individualsNum;
    private ArrayList<Individual> swarmMembers;
    private ArrayList<int, int> distances;
    private Room room;

    public void initSwarm(int num) {
        this.individualsNum = num;
        this.swarmMembers = new ArrayList<>(this.individualsNum);
        for (Individual member : swarmMember) {
            member.initMember();
        }
    }
}
