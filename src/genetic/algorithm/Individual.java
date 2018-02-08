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
public class Individual implements Evaluable {

     public int fitness;
     public byte[] DNA;

    public Individual() {
        DNA = randStrategy();
    }   //empty default constructor

    public Individual(int fitness, byte[] DNA) {   //initializing constructor
        this();   // invoke the default constructor
        this.fitness = fitness;
        this.DNA = DNA;
    }
    
    public Individual(byte[] DNA) {   //initializing constructor
        this();   // invoke the default constructor
        this.DNA = DNA;
    }
    private byte[] randStrategy() {
        byte[] returnMe = new byte[Globals.DNA_SIZE];

        for (int i = 0; i < Globals.DNA_SIZE; i++) {
            byte rand = (byte) (Math.random() * 2);
            returnMe[i] = rand;
        }

        return returnMe;

    }

    public int getFitness() {
        return fitness;
    }

    public byte[] getDNA() {
        return DNA;
    }

     @Override
    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    public void setDNA(byte[] DNA) {
        this.DNA = DNA;
    }

    public String toString() {
        String returnMe = "Individual:";
        returnMe += "\tfitness=" + getFitness();
        returnMe += "\tDNA=" + returnDNA();
        return returnMe;
    } // toString()

    @Override
    public Evaluable myClone() {
        int fit = fitness;
       return new Individual(fit, DNA.clone());
        
    }

    public String returnDNA() {
        String returnMe = "";
        for (byte b : DNA) {
            returnMe += b;
        }
        return returnMe;
    }

    private byte[] copy() {
        byte[] b = new byte[Globals.DNA_SIZE];
        for (int i = 0; i < Globals.DNA_SIZE; i++) {
            b[i] = DNA[i]; 
        }
        return b;
    }
}  // Individual
