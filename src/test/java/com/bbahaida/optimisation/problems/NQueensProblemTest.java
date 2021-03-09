package com.bbahaida.optimisation.problems;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NQueensProblemTest {
    @Test
    public void solve() {
        NQueensProblem nQueensProblem = new NQueensProblem();

        int[][] expected = {{0, 0, 1, 0}, {1, 0, 0, 0}, {0, 0, 0, 1}, {0, 1, 0, 0}};
        Assertions.assertThat(nQueensProblem.solve(4)).isEqualTo(expected);
    }
}
