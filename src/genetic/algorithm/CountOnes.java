/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic.algorithm;

/**
 *
 * @author Ari
 */
public class CountOnes {
    public static int getValue(Evaluable nextInd) {
        int count = 0;

        for (byte nextByte : nextInd.getDNA()) {
            if (nextByte == 1) {
                count++;
            }
        }
//        System.out.println("count = " + count);
        return count;
    }
}
