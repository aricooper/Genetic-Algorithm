package genetic.algorithm;

public class Population {

    public IndividualList list = new IndividualList();
    int gen = 0;
    boolean ordering = true;

    public Population() {
        populate();
    }   //empty default constructor

    public Population(IndividualList list) {   //initializing constructor
        this();   // invoke the default constructor
        this.list = list;
    }

    public IndividualList getList() {
        return list;
    }

    public void setList(IndividualList list) {
        this.list = list;
    }

    public void evaluateFitness(int n) {
        switch (n) {

            case 0:
                for (Evaluable nextInd : list) {
                    if (ordering) {
                        gen++;
                    }
                    nextInd.setFitness(CountOnes.getValue(nextInd));
//                    System.out.println("nextInd = " + nextInd);
                }
                break;
            case 1:
                for (Evaluable nextInd : list) {
                    if (ordering) {
                        gen++;
                    }
                    nextInd.setFitness(Fitness4.getValue(nextInd));
                }
                break;
            case 2:
                for (Evaluable nextInd : list) {
                    if (ordering) {
                        gen++;
                    }
                    nextInd.setFitness(Mystery.getValue(nextInd));
                }
                break;

        }
        FitnessComparator fc = new FitnessComparator();
        list.sort(fc);
    }

    public void selectMatingPool() {

        IndividualList nuList = new IndividualList();
        for (int i = 0; i < (Globals.POP_SIZE - Globals.MATING_POOL); i++) {
//            System.out.println("list.size()-1 = " + (list.size()-1));
            nuList.add(list.get(i));
        }
        list = nuList;

    }

    public void applyGeneticOperators() {

        for (int i = 0; i < Globals.MATING_POOL; i++) {

            mutate(list.get(i).myClone());

//        System.out.println("list = " + list);
//        System.out.println("*************************************************");
        }
    }

    public void populate() {
//        System.out.println("Globals.POP_SIZE = " + Globals.POP_SIZE);
        for (int i = 0; i < Globals.POP_SIZE; i++) {
            list.add(new Individual());
        }
    }

    void run(int n) {
        while (gen < Globals.GENERATIONS) {
            ordering = true;
            evaluateFitness(n);
            selectMatingPool();
            applyGeneticOperators();
            applyCrossover();
            ordering = false;
            evaluateFitness(n);

        }
    }

    public String toString() {
        String returnMe = "Population: Size = " + Globals.POP_SIZE + ", Mutation Rate = " + Globals.MUTATION_RATE + "\n";
        for (Evaluable I : list) {
            returnMe += "\n" + I;
        }
        return returnMe;
    } // toString()

    

    private void mutate(Evaluable I) {

        for (int i = 0; i < Globals.DNA_SIZE; i++) {
            int rand = (int) (Math.random() * Globals.MUTATION_RATE);
            if (rand == 5) {
//                System.out.println("changed");
                switch (I.getDNA()[i]) {
                    case 0:
                        I.getDNA()[i] = 1;
                    case 1:
                        I.getDNA()[i] = 0;
                }
            }
        }
//        System.out.println("\t mutated(?) : " + I);
        list.add(I);

    }

    private void applyCrossover() {
        for (int i = 0; i < Globals.POP_SIZE; i++) {
            if (Globals.HEADLESS_CHICKEN) {
                cross(list.get(i), new Individual(), 0);
            }else {
            cross(list.get(i), list.get(rand(list.size())), 0);
            }
        }

    }

    public int rand(int n) {
        return (int) (Math.random() * n);
    }

    private void cross(Evaluable first, Evaluable second, int n) {
        while (n < Globals.CROSS) {
            int start = rand(Globals.DNA_SIZE);
            for (int i = start; i < Globals.DNA_SIZE; i++) {
                byte temp = first.getDNA()[i];
                first.getDNA()[i] = second.getDNA()[i];
                second.getDNA()[i] = temp;
            }
            n++;
            
        }
        
    }

    Double getAverageFitness() {
        double sum = 0;
//        System.out.println("list.size1() = " + list.size());
        for (Evaluable I : list) {
            sum += I.getFitness();

        }
        return (sum / list.size());
    }

}  // Population

