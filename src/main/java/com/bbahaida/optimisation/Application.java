package com.bbahaida.optimisation;

import com.bbahaida.optimisation.genetic.GeneticAlgorithm;
import com.bbahaida.optimisation.genetic.Population;

import static com.bbahaida.optimisation.genetic.Constants.MAX_FITNESS;

public class Application {

    public static void main(String[] args) {
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
        Population population = new Population(100);
        population.initialize();

        int generationCount = 0;

        while (population.getFittestIndividual().getFitness() < MAX_FITNESS) {
            ++generationCount;
            System.out.println(String.format("Generation: %d - fittest: %d", generationCount, population.getFittestIndividual().getFitness()));
            System.out.println(population.getFittestIndividual());
            population = geneticAlgorithm.evolvePopulation(population);
        }
        System.out.println("Solution found");
        System.out.println(population.getFittestIndividual());
    }
}
