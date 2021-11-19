package csc.linear.system.util;

import csc.linear.system.domain.Vector;

public class VectorUtils {

    public static Vector generateVector(int size, double max, boolean castToInt) {
        double[][] vector = new double[size][1];
        for (int i = 0; i < size; i++) {
            vector[i][0] = castToInt ? (int) (Math.random() * max + 1) : (Math.random() * max);
        }
        return new Vector(vector);
    }

}
