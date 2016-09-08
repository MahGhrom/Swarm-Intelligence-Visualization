package core;

import java.util.Vector;

/**
 *
 * Created by (serhii.vasylchenko@gmail.com) on 02.09.2016.
 */
public class Distance {

    public static double euclidean(Vector<Double> v1, Vector<Double> v2) {
        if (v1.size() != v2.size()) {
            System.out.println("Vectors have different dimensions");
            return -1;
        }
        double sum = 0;
        for (int i = 0; i < v1.size(); i++) {
            sum += Math.pow((v1.get(i) - v2.get(i)), 2);
        }
        return Math.sqrt(sum);
    }
}
