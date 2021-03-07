package com.bbahaida.optimisation.problems;

public class NQueensProblem {

    public int[][] solve(int n) {

        int[][] board = new int[n][n];
        solveUsingBacktracking(board, 0);
        return board;
    }

    private boolean solveUsingBacktracking(int[][] board, int column) {
        if (column >= board.length) {
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            if (isSave(board, i, column)) {
                board[i][column] = 1;
                if (solveUsingBacktracking(board, column + 1)) {
                    return true;
                }
                board[i][column] = 0;
            }
        }
        return false;
    }

    private boolean isSave(int[][] board, int row, int column) {
        return !threaten(board, row, column);
    }

    private boolean threaten(int[][] board, int row, int column) {
        return columnHasThreat(board, row, column) ||
                diagonalHasThreat(board, row, column) ||
                reverseDiagonalHasThreat(board, row, column);
    }

    private boolean columnHasThreat(int[][] board, int row, int column) {
        for (int i = 0; i < column; i++) {
            if (board[row][i] == 1) {
                return true;
            }
        }
        return false;
    }

    private boolean diagonalHasThreat(int[][] board, int row, int column) {
        for (int i = row, j = column; i > -1 && j > -1; i--, j--) {
            if (board[i][j] == 1) {
                return true;
            }
        }
        return false;
    }

    private boolean reverseDiagonalHasThreat(int[][] board, int row, int column) {
        for (int i = row, j = column; i < board.length && j > -1; i++, j--) {
            if (board[i][j] == 1) {
                return true;
            }
        }
        return false;
    }

    public String printResult(int n) {
        StringBuilder board = new StringBuilder();
        int[][] result = solve(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String c = result[i][j] == 1 ? "R " : "- ";
                board.append(c);
            }
            board.append("\n");
        }
        return board.toString();
    }
}
