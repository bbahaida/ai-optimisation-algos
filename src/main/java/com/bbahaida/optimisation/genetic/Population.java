package com.bbahaida.optimisation.genetic;

public class Population {
    private Individual[] individuals;

    public Population(int populationSize) {
        this.individuals = new Individual[populationSize];
    }

    public void initialize(){
        for (int i = 0; i < individuals.length; i++) {
            Individual individual = new Individual();
            individual.generateIndividual();
            saveIndividual(i, individual);
        }
    }

    public Individual getFittestIndividual(){
        int fittestIndex = 0;
        for (int i = 1; i < individuals.length; i++) {
            Individual candidate = individuals[i];
            if (candidate.getFitness() > individuals[fittestIndex].getFitness()) {
                fittestIndex = i;
            }
        }
        return individuals[fittestIndex];
    }

    public int size(){
        return individuals.length;
    }

    public void saveIndividual(int index, Individual individual) {
        individuals[index] = individual;
    }

    public Individual getIndividual(int index) {
        return this.individuals[index];
    }
}
