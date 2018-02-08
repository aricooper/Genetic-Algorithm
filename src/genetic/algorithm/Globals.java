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
public class Globals {

    static int DNA_SIZE = 100;
    static int POP_SIZE = 5;
    static int MUTATION_RATE = 10;
    static int MATING_POOL;
    static int GENERATIONS = 10000;
    static int CROSS = 2;
    static boolean HEADLESS_CHICKEN = false;
    
    static void setPop(int n) {
        POP_SIZE = n;
    }
}
