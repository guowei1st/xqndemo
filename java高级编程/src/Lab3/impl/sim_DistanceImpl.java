package Lab3.impl;

import Lab3.Server;

public class sim_DistanceImpl implements Server {


    /*
    欧几里得距离算法
     */

    public static double sim_distance(Double[] vector1, Double[] vector2) {
        double distance = 0;

        if (vector1.length == vector2.length) {
            for (int i = 0; i < vector1.length; i++) {
                double temp = Math.pow((vector1[i] - vector2[i]), 2);
                distance += temp;
            }
            distance = Math.sqrt(distance);
        }
        return distance;
    }

}
