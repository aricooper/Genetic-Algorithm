/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic.algorithm;

import java.util.ArrayList;

/**
 *
 * @author Ari
 */
class IndividualList extends ArrayList<Evaluable> {
    public String toString() {
        String returnMe = "";
        for (Evaluable next : this) {
            returnMe += "\n";
            for (int i = 0; i < Globals.DNA_SIZE; i++) {
                returnMe += " " + next.getDNA()[i];
            }
        }
        return returnMe;
    }
}
