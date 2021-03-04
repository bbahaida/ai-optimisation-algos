package com.bbahaida.optimisation.genetic;

import java.util.Random;

import static com.bbahaida.optimisation.genetic.Constants.*;

public class GeneticAlgorithm {

    private Random randomGenerator;
    public GeneticAlgorithm(){
        this.randomGenerator = new Random();
    }

    public Population evolvePopulation(Population population) {
        Population newPopulation = new Population(population.size());
        for (int i = 0; i < population.size(); i++) {
            Individual firstIndividual = randomSelection(population);
            Individual secondIndividual = randomSelection(population);

            Individual newIndividual = crossover(firstIndividual, secondIndividual);
            newPopulation.saveIndividual(i, newIndividual);
        }

        for (int i = 0; i < newPopulation.size(); i++) {
            mutate(newPopulation.getIndividual(i));
        }

        return newPopulation;
    }

    private void mutate(Individual individual) {
        for (int i = 0; i < CHROMOSOME_LENGTH; i++) {
            if (Math.random() <= MUTATION_RATE) {
                int gene = randomGenerator.nextInt(CHROMOSOME_LENGTH);
                individual.setGene(gene, i);
            }
        }
    }

    private Individual crossover(Individual firstIndividual, Individual secondIndividual) {
        Individual individual = new Individual();
        for (int i = 0; i < CHROMOSOME_LENGTH; i++) {
            if (Math.random() <= CROSSOVER_RATE) {
                individual.setGene(firstIndividual.getGene(i), i);
            } else {
                individual.setGene(secondIndividual.getGene(i), i);
            }
        }

        return individual;
    }

    private Individual randomSelection(Population population) {
        Population newPopulation = new Population(TOURNAMENT_SIZE);

        for (int i = 0; i < TOURNAMENT_SIZE; i++) {
            int randomIndex = (int) (Math.random() * population.size());
            newPopulation.saveIndividual(i, population.getIndividual(randomIndex));
        }
        return newPopulation.getFittestIndividual();
    }
}
