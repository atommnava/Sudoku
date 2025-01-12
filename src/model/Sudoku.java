package model;

/**
 *
 * @author alexandermunoznava
 */
public class Sudoku {
    private int sudoku[][];
    public Sudoku(){
        int sudo[][] = {
            {0, 6, 0,  1, 0, 4,  0, 5, 0},
            {0, 0, 8,  3, 0, 5,  6, 0, 0},
            {2, 0, 0,  0, 0, 0,  0, 0, 1},
            
            {8, 0, 0,  4, 0, 7,  0, 0, 6},
            {0, 0, 6,  0, 0, 0,  3, 0, 0},
            {7, 0, 0,  9, 0, 1,  0, 0, 4},
            
            {5, 0, 0,  0, 0, 0,  0, 0, 2},
            {0, 0, 7,  2, 0, 6,  9, 0, 0},
            {0, 4, 0,  5, 0, 8,  0, 7, 0},
        };
        sudoku = sudo;
    }
    
    public void resolveSudoku(){
        int i;
        int j;
        int value;
        for (i = 0; i < sudoku.length; i++) {
            for (j = 0; j < sudoku[0].length; j++) {
                if (sudoku[i][j] == 0) {
                    for (value = 1; value <= 9; value++) {
                        if (rowValidation(i, value) && columnValidation(j, value) && quadrantValidation(i, j, value)) {
                            sudoku[i][j] = value;
                        }
                    }
                }
            }
        }
    }
    
    public boolean rowValidation(int row, int value) {
        int j;
        for (j = 0; j < sudoku[row].length; j++) {
            if (sudoku[row][j] == value) {
                return false;
            }
        }
        return true;
    }
    
    public boolean columnValidation(int column, int value) {
        int i;
        for (i = 0; i < sudoku.length; i++) {
           if (sudoku[i][column] == value) {
               return false;
           }
        }
        return true;
    }
    
    public boolean quadrantValidation(int i, int j, int value) {
        int posI = currentSubquadrant(i);
        int posJ = currentSubquadrant(j);
        int k;
        int l;
        
        for (k = posI - 3; k < posI; k++) {
            for (l = posJ - 3; l < posJ; l++) {
                if (sudoku[k][l] == value) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int currentSubquadrant(int pos) {
        if (pos <= 2) return 3;
        else if (pos <= 5) return 6;
        else return 9;
    }

    public void setSudoku(int[][] sudoku) {
        this.sudoku = sudoku;
    }

    public int[][] getSudoku() {
        return sudoku;
    }
}
