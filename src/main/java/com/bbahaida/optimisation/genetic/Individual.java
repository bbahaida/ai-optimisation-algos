package com.bbahaida.optimisation.genetic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Random;

import static com.bbahaida.optimisation.genetic.Constants.CHROMOSOME_LENGTH;
import static com.bbahaida.optimisation.genetic.Constants.SOLUTION_SEQUENCE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Individual {
    private int[] genes = new int[CHROMOSOME_LENGTH];
    private Random randomGenerator = new Random();
    private int fitness;

    public void generateIndividual(){
        for (int i = 0; i < CHROMOSOME_LENGTH; i++) {
            int gene = randomGenerator.nextInt(CHROMOSOME_LENGTH);
            genes[i] = gene;
        }
    }

    public int getFitness() {
        if (fitness == 0) {
            for (int i = 0; i < CHROMOSOME_LENGTH; i++) {
                if (genes[i] == SOLUTION_SEQUENCE[i]) {
                    fitness++;
                }
            }
        }
        return fitness;
    }

    public void setGene(int gene, int index) {
        genes[index] = gene;
    }

    public int getGene(int index) {
        return genes[index];
    }

}
