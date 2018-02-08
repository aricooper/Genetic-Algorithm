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
public interface Evaluable {
    public byte[] getDNA();
    public int getFitness();
    public void setFitness(int fitness);
    public Evaluable myClone();
}
